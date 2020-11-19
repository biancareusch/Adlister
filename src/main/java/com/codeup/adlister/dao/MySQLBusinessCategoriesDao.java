package com.codeup.adlister.dao;

import com.codeup.adlister.models.BusinessCategory;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLBusinessCategoriesDao implements BusinessCategories{
    private Connection connection;

    public MySQLBusinessCategoriesDao(Config config) {
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
    public List<BusinessCategory> all() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM business_categories");
            ResultSet rs = stmt.executeQuery();
            return createBusinessCategoriesFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all business categories.", e);
        }
    }

    @Override
    public BusinessCategory findByCategoryId(Long categoryId) {
        String query = "SELECT * FROM business_categories WHERE id = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            String searchID = String.valueOf(categoryId);
            stmt.setString(1, searchID);
            return extractBusinessCategories(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a business category by category id", e);
        }
    }

    @Override
    public Long insert(BusinessCategory businessCategory) {
        String query = "INSERT INTO business_categories(businessAd_id, name) VALUES (?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, businessCategory.getBusinessAdId());
            stmt.setString(2, businessCategory.getName());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating new business category", e);
        }
    }

    private BusinessCategory extractBusinessCategories(ResultSet rs) throws SQLException {
        if (! rs.next()) {
            return null;
        }
        return new BusinessCategory(
                rs.getLong("id"),
                rs.getLong("businessAd_id"),
                rs.getString("name")
        );
    }

    private List<BusinessCategory> createBusinessCategoriesFromResults(ResultSet rs) throws SQLException {
        List<BusinessCategory> businessCategories = new ArrayList<>();
        while (rs.next()) {
            System.out.println(rs.getString("description"));
            businessCategories.add(extractBusinessCategories(rs));
        }
        return businessCategories;
    }
}
