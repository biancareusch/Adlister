package com.codeup.adlister.dao;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Business;
import com.codeup.adlister.models.Category;
import com.mysql.cj.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLCategoriesDao implements Categories {
    private Connection connection;

    public MySQLCategoriesDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public List<Category> all() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM categories");
            ResultSet rs = stmt.executeQuery();
            return createCategoriesFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all categories.", e);
        }
    }

    @Override
    public Category findByCategoryId(Long categoryId) {
        String query = "SELECT * FROM categories WHERE id = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            String searchID = String.valueOf(categoryId);
            stmt.setString(1, searchID);
            return extractCategories(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a category by category id", e);
        }
    }

    @Override
    public Long insert(Category category) {
        String query = "INSERT INTO categories(ad_id, name) VALUES (?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, category.getAdId());
            stmt.setString(2, category.getName());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating new category", e);
        }
    }

    private Category extractCategories(ResultSet rs) throws SQLException {
        if (! rs.next()) {
            return null;
        }
        return new Category(
                rs.getLong("id"),
                rs.getLong("ad_id"),
                rs.getString("name")
        );
    }

    private List<Category> createCategoriesFromResults(ResultSet rs) throws SQLException {
        List<Category> categories = new ArrayList<>();
        while (rs.next()) {
            System.out.println(rs.getString("description"));
            categories.add(extractCategories(rs));
        }
        return categories;
    }



}
