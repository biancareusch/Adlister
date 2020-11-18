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
            throw new RuntimeException("Error finding a category by category name", e);
        }
    }

    @Override
    public Long insert(Category category) {
        String query = "INSERT INTO categories(name, ad_id) VALUES (?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, category.getName());
            stmt.setLong(2, category.getAdId());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating new user", e);
        }
    }

    private Category extractCategories(ResultSet rs) throws SQLException {
        if (! rs.next()) {
            return null;
        }
        return new Category(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getLong("ad_id")
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
