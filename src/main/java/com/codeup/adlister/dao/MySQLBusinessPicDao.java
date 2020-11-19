package com.codeup.adlister.dao;

import com.codeup.adlister.models.UserPicture;
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
            throw new RuntimeException("Error finding a business picture by ID", e);
        }
    }

    //add user id to picture object
    //grab session id and ad it into insert pic


    @Override
    public Long insertPic(BusinessPicture businessPicture) {
        String query = "INSERT INTO business_pictures(business_img_url, business_id) VALUES (?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, businessPicture.getBusinessImgUrl());
            stmt.setLong(2, businessPicture.getBusinessId());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error adding business picture", e);
        }
    }

    private BusinessPicture extractPic(ResultSet rs) throws SQLException {
        if (!rs.next()) {
            return null;
        }
        return new BusinessPicture(
                rs.getLong("id"),
                rs.getString("business_img_url"),
                rs.getString("alt_text"),
                rs.getLong("business_id")
        );
    }

    @Override
    public BusinessPicture findByPicBusinessID(long businessID) {
        String query = "SELECT * FROM business_pictures WHERE business_id = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            String searchID = String.valueOf(businessID);
            stmt.setString(1, searchID);
            return extractPic(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a business picture by Business ID", e);
        }
    }

    @Override
    public void updatePicURL(String newPicURL, long businessID) {
        String query = "UPDATE business_pictures SET  business_img_url = ? WHERE business_id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, newPicURL);
            stmt.setLong(2, businessID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating a picture by Business ID", e);
        }
    }
}
