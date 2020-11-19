package com.codeup.adlister.dao;

import com.codeup.adlister.models.AdPicture;
import com.codeup.adlister.models.BusinessAdPicture;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class MySQLBusinessAdPicturesDao implements BusinessAdPictures {
    private Connection connection;

    public MySQLBusinessAdPicturesDao(Config config) {
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
    public BusinessAdPicture findByPicID(long picID) {
        String query = "SELECT * FROM businessAds_pictures WHERE id = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            String searchID = String.valueOf(picID);
            stmt.setString(1, searchID);
            return extractPic(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a business ad picture by ID", e);
        }
    }

    @Override
    public Long insertPic(BusinessAdPicture businessAdPicture) {
        String query = "INSERT INTO businessAds_pictures(business_ad_img_url) VALUES (?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, businessAdPicture.getBusinessAdImgUrl());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating business ad picture", e);
        }
    }

    private BusinessAdPicture extractPic(ResultSet rs) throws SQLException {
        if (! rs.next()) {
            return null;
        }
        return new BusinessAdPicture(
                rs.getLong("id"),
                rs.getString("business_ad_img_url"),
                rs.getString("alt_text"),
                rs.getLong("businessAd_id"),
                rs.getString("create_time")
        );
    }
}
