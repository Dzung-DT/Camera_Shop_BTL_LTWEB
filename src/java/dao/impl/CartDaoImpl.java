package dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.CartDao;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cart;
import model.Person;
import service.PersonService;
import service.impl.PersonServiceImpl;

public class CartDaoImpl extends JDBCConnection implements CartDao {

    PersonService personService = new PersonServiceImpl();

    @Override
    public void insert(Cart cart) {
        String sql = "INSERT INTO cart(person_id, buy_date, name_order, phone_order, address_order) VALUES (?,?,?,?,?)";
        Connection conn = super.getConnect();

        try {
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, cart.getBuyer().getId());
            ps.setDate(2, new Date(cart.getBuyDate().getTime()));
            ps.setString(3, cart.getNameOrder());
            ps.setString(4, cart.getPhoneOrder());
            ps.setString(5, cart.getAddressOrder());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                cart.setId(id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CartDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void edit(Cart cart) {
        String sql = "UPDATE cart SET person_id = ?, buy_date = ? WHERE cart_id = ?";
        Connection con = super.getConnect();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cart.getBuyer().getId());
            ps.setDate(2, new Date(cart.getBuyDate().getTime()));
            ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(CartDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM cart WHERE cart_id = ?";
        Connection con = super.getConnect();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(CartDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Cart get(int id) {
        String sql = "SELECT cart.cart_id, cart.buy_date, cart.name_order, cart.phone_order, cart.address_order, person.username, person.id AS person_id "
                + "FROM cart INNER JOIN person " + "ON cart.person_id = person.id WHERE cart.cart_id=?";
        Connection con = super.getConnect();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Person person = personService.get(rs.getInt("person_id"));

                Cart cart = new Cart();
                cart.setId(rs.getInt("cart_id"));
                cart.setBuyDate(rs.getDate("buy_date"));
                cart.setBuyer(person);
                cart.setNameOrder(rs.getString("name_order"));
                cart.setPhoneOrder(rs.getString("phone_order"));
                cart.setAddressOrder(rs.getString("address_order"));

                return cart;

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(CartDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Cart> getAll() {
        List<Cart> cartList = new ArrayList<Cart>();
        String sql = "SELECT cart.cart_id, cart.buy_date, cart.name_order, cart.phone_order, cart.address_order, person.username, person.id AS person_id "
                + "FROM cart INNER JOIN person " + "ON cart.person_id = person.id";
        Connection con = super.getConnect();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Person person = personService.get(rs.getInt("person_id"));

                Cart cart = new Cart();
                cart.setId(rs.getInt("cart_id"));
                cart.setBuyDate(rs.getDate("buy_date"));
                cart.setBuyer(person);
                cart.setNameOrder(rs.getString("name_order"));
                cart.setPhoneOrder(rs.getString("phone_order"));
                cart.setAddressOrder(rs.getString("address_order"));
                cartList.add(cart);

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(CartDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cartList;
    }

    @Override
    public Cart get(String name) {
        // TODO Auto-generated method stub
        return null;
    }
}
