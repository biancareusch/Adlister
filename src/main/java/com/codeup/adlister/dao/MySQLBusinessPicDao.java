package com.codeup.adlister.dao;

import com.mysql.cj.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.*;
import com.codeup.adlister.models.BusinessPicture;

public class MySQLBusinessPicDao implements BusinessPictures {
    private Connection connection;

    public MySQLBusinessPicDao(Config config) {
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
    public BusinessPicture findByPicID(long picID) {
        String query = "SELECT * FROM business_pictures WHERE id = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            String searchID = String.valueOf(picID);
            stmt.setString(1, searchID);
            return extractPic(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a picture by ID", e);
        }
    }

    @Override
    public Long insertPic(BusinessPicture businessPicture) {
        String query = "INSERT INTO business_pictures(url) VALUES (?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, businessPicture.getUrl());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating new user", e);
        }
    }

    private BusinessPicture extractPic(ResultSet rs) throws SQLException {
        if (! rs.next()) {
            return null;
        }
        return new BusinessPicture(
                rs.getLong("id"),
                rs.getString("imgURL")
        );
    }
}
