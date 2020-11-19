package com.codeup.adlister.dao;

import com.codeup.adlister.models.Banner;
import com.mysql.cj.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.*;

public class MySQLBannersDao implements Banners{
    private Connection connection;

    public MySQLBannersDao(Config config) {
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
    public Banner findById(long id) {
        String query = "SELECT * FROM banner_ads WHERE id = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            String searchID = String.valueOf(id);
            stmt.setString(1, searchID);
            return extractBanner(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a banner ad by id", e);
        }
    }

    @Override
    public Banner findByUserID(long userId) {
        String query = "SELECT * FROM banner_ads WHERE id = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            String searchID = String.valueOf(userId);
            stmt.setString(1, searchID);
            return extractBanner(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a banner by userid", e);
        }
    }

    @Override
    public Banner findByAdID(long adId) {
        String query = "SELECT * FROM banner_ads WHERE id = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            String searchID = String.valueOf(adId);
            stmt.setString(1, searchID);
            return extractBanner(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a banner by adId", e);
        }
    }

    @Override
    public Long insert(Banner banner) {
        String query = "INSERT INTO banner_ads(title, description, url, ad_id) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, banner.getTitle());
            stmt.setString(2, banner.getDescription());
            stmt.setString(3, banner.getUrl());
            stmt.setLong(4, banner.getAdId());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating new banner", e);
        }
    }


    private Banner extractBanner(ResultSet rs) throws SQLException {
        if (! rs.next()) {
            return null;
        }
        return new Banner(
                rs.getLong("id"),
                rs.getString("title"),
                rs.getString("description"),
                rs.getString("url"),
                rs.getLong("ad_id")
        );
    }
}
