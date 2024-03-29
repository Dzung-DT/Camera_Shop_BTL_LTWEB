package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.PersonDao;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Person;

public class PersonDaoImpl implements PersonDao {
    
    private Connection conn = JDBCConnection.getInstance().getConnection();

    
    @Override
    public void create(Person p) {      
        try {
            String sql = "INSERT INTO person(name, age, address, username, password, role, avatar_file_name) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, p.getName());
            statement.setInt(2, p.getAge());
            statement.setString(3, p.getAdd());
            statement.setString(4, p.getUsername());
            statement.setString(5, p.getPassword());
            statement.setString(6, p.getRole());
            statement.setString(7, p.getAvatarFileName());
            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                int id = generatedKeys.getInt(1);
                p.setId(id);
            }
        } catch (Exception e) {
            System.out.println("Loi CSDL: " + e);
        }
    }

    @Override
    public void update(Person p) {
       
        try {
            String sql = "UPDATE person SET username = ?, password = ?, name = ?, age = ?, address = ?, role = ?, avatar_file_name = ? WHERE (id = ?) ";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, p.getUsername());
            statement.setString(2, p.getPassword());
            statement.setString(3, p.getName());
            statement.setInt(4, p.getAge());
            statement.setString(5, p.getAdd());
            statement.setString(6, p.getRole());
            statement.setString(7, p.getAvatarFileName());
            statement.setInt(8, p.getId());

            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Loi CSDL: " + e);
        }
    }

    @Override
    public void delete(int id) {
 
        try {
            String sql = "DELETE FROM person WHERE id = ? ";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);

            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Loi CSDL: " + e);
        }
    }

    @Override
    public Person get(int id) {
  
        try {
            String sql = "SELECT * FROM person WHERE id =?";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Person p = new Person();
                p.setId(id);
                p.setName(rs.getString("name"));
                p.setAge(rs.getInt("age"));
                p.setAdd(rs.getString("address"));
                p.setUsername(rs.getString("username"));
                p.setPassword(rs.getString("password"));
                p.setRole(rs.getString("role"));
                p.setAvatarFileName(rs.getString("avatar_file_name"));
                return p;
            }
        } catch (Exception e) {
            System.out.println("Loi CSDL: " + e);
        }
        return null;
    }

    @Override
    public List<Person> search(String name) {
        List<Person> persons = new ArrayList<Person>();
    
        try {
            String sql = "SELECT * FROM person WHERE name LIKE ?";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, "%" + name + "%");

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Person p = new Person();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setAge(rs.getInt("age"));
                p.setAdd(rs.getString("address"));
                p.setUsername(rs.getString("username"));
                p.setPassword(rs.getString("password"));
                p.setRole(rs.getString("role"));
                p.setAvatarFileName(rs.getString("avatar_file_name"));
                persons.add(p);
            }
        } catch (Exception e) {
            System.out.println("Loi CSDL: " + e);
        }
        return persons;
    }

    @Override
    public Person getByUsername(String username) { 

        try {
            String sql = "SELECT * FROM person WHERE username =?";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, username);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Person p = new Person();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setAge(rs.getInt("age"));
                p.setAdd(rs.getString("address"));
                p.setUsername(rs.getString("username"));
                p.setPassword(rs.getString("password"));
                p.setRole(rs.getString("role"));
                p.setAvatarFileName(rs.getString("avatar_file_name"));
                return p;
            }
        } catch (Exception e) {
            System.out.println("Loi CSDL: " + e);
        }
        return null;
    }
}
