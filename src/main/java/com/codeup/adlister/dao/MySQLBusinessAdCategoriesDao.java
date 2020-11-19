package com.codeup.adlister.dao;

import com.codeup.adlister.models.BusinessAdCategory;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class MySQLBusinessAdCategoriesDao implements BusinessAdCategories{
    private Connection connection;

    public MySQLBusinessAdCategoriesDao(Config config) {
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
    public BusinessAdCategory findByCategoryName(String categoryName){
        String query = "SELECT * FROM business_ads AS ad JOIN business_categories AS cat ON ad.id = cat.businessAd_id WHERE name = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            String searchID = String.valueOf(categoryName);
            stmt.setString(1, searchID);
            return extractBusinessAdCategory(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a category ad by name", e);
        }
    };

    private BusinessAdCategory extractBusinessAdCategory(ResultSet rs) throws SQLException {
        if (! rs.next()) {
            return null;
        }
        return new BusinessAdCategory(
                rs.getLong("ad_id"),
                rs.getLong("category_id"),
                rs.getString("name"),
                rs.getString("title"),
                rs.getString("description")
        );
    }
}
