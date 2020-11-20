package com.codeup.adlister.dao;
import com.codeup.adlister.models.AdCategory;
import com.mysql.cj.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.*;

public class MySQLAdCategoriesDao implements AdCategories {
    private Connection connection;

    public MySQLAdCategoriesDao(Config config) {
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
    public AdCategory findByCategoryName(String categoryName){
        String query = "SELECT * FROM ads AS ad JOIN categories AS cat ON ad.id = cat.ad_id WHERE name = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            String searchID = String.valueOf(categoryName);
            stmt.setString(1, searchID);
            return extractAdCategory(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a banner ad by id", e);
        }
    };

    private AdCategory extractAdCategory(ResultSet rs) throws SQLException {
        if (! rs.next()) {
            return null;
        }
        return new AdCategory(
                rs.getLong("ad_id"),
                rs.getLong("category_id"),
                rs.getString("name"),
                rs.getString("title"),
                rs.getString("description")
        );
    }
}
