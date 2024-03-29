package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Category;

import dao.CategoryDao;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CategoryDaoImpl  implements CategoryDao {
    
     private Connection con = JDBCConnection.getInstance().getConnection();
    
    @Override
    public void insert(Category category) {

       

        try {
            String sql = "INSERT INTO category(cate_name) " + "VALUES (?)";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, category.getName());
            ps.executeUpdate();

            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                int id = generatedKeys.getInt(1);
                category.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
     
    }

    @Override
    public void edit(Category category) {

      

        try {
            String sql = "UPDATE category SET cate_name = ? WHERE cate_id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, category.getName());
            ps.setInt(2, category.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
     
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM category WHERE cate_id = ?";
      

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Category get(int id) {
        String sql = "SELECT * FROM category WHERE cate_id = ? ";
       
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Category category = new Category();

                category.setId(rs.getInt("cate_id"));
                category.setName(rs.getString("cate_name"));

                return category;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
   
        return null;
    }

    @Override
    public List<Category> getAll() {
        List<Category> categories = new ArrayList<Category>();
        String sql = "SELECT * FROM category";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Category category = new Category();

                category.setId(rs.getInt("cate_id"));
                category.setName(rs.getString("cate_name"));

                categories.add(category);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
     
        return categories;
    }

    @Override
    public List<Category> search(String keyword) {
        List<Category> categories = new ArrayList<Category>();
        String sql = "SELECT * FROM category WHERE name LIKE ? ";
     

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Category category = new Category();

                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));

                categories.add(category);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return categories;
    }

    @Override
    public Category get(String name) {
        String sql = "SELECT * FROM category WHERE cate_name = ? ";
       
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Category category = new Category();

                category.setId(rs.getInt("cate_id"));
                category.setName(rs.getString("cate_name"));

                return category;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return null;
    }
}
