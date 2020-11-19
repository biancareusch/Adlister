package com.codeup.adlister.dao;

import com.codeup.adlister.models.BusinessProfile;
import com.mysql.cj.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.*;

public class MySQLBusinessProfilesDao implements BusinessProfiles{
    private Connection connection;

    public MySQLBusinessProfilesDao(Config config) {
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
    public BusinessProfile findByBusinessId(long businessId) {
        String query = "SELECT * FROM business_profiles WHERE id = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            String searchID = String.valueOf(businessId);
            stmt.setString(1, searchID);
            return extractBusinessProfile(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a business by business name", e);
        }
    }

    @Override
    public Long insert(BusinessProfile businessProfile) {
        String query = "INSERT INTO business_profiles(business_id, about_me, phone_number, profile_pic, ad_id, website_url, viewing_preference) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, businessProfile.getBusinessId());
            stmt.setString(2, businessProfile.getAboutMe());
            stmt.setString(3, businessProfile.getPhoneNumber());
            stmt.setString(4, businessProfile.getProfilePic());
            stmt.setLong(5, businessProfile.getAdId());
            stmt.setString(6, businessProfile.getWebsiteURL());
            stmt.setBoolean(7, businessProfile.getViewingPreference());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating new user", e);
        }
    }

    private BusinessProfile extractBusinessProfile(ResultSet rs) throws SQLException {
        if (! rs.next()) {
            return null;
        }
        return new BusinessProfile(
                rs.getLong("id"),
                rs.getLong("business_id"),
                rs.getString("about_me"),
                rs.getString("phone_number"),
                rs.getString("profile_pic"),
                rs.getLong("ad_id"),
                rs.getString("website_url"),
                rs.getBoolean("viewing_preference")
        );
    }

}
