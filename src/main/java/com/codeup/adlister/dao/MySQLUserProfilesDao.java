package com.codeup.adlister.dao;

import com.codeup.adlister.models.UserProfile;
import com.mysql.cj.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.*;

public class MySQLUserProfilesDao implements UserProfiles{
    private Connection connection;

    public MySQLUserProfilesDao(Config config) {
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
    public UserProfile findByUserId(long userId) {
        String query = "SELECT * FROM user_profiles WHERE id = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            String searchID = String.valueOf(userId);
            stmt.setString(1, searchID);
            return extractUserProfile(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a user by user id", e);
        }
    }

    @Override
    public Long insert(UserProfile userProfile) {
        String query = "INSERT INTO user_profiles(user_id, about_me, phone_number, profile_pic, ad_id, viewing_preference) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, userProfile.getUserId());
            stmt.setString(2, userProfile.getAboutMe());
            stmt.setString(3, userProfile.getPhoneNumber());
            stmt.setString(4, userProfile.getProfilePic());
            stmt.setLong(5, userProfile.getAdId());
            stmt.setBoolean(6, userProfile.getViewingPreference());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating new user", e);
        }
    }

    private UserProfile extractUserProfile(ResultSet rs) throws SQLException {
        if (! rs.next()) {
            return null;
        }
        return new UserProfile(
                rs.getLong("id"),
                rs.getLong("user_id"),
                rs.getString("about_me"),
                rs.getString("phone_number"),
                rs.getString("profile_pic"),
                rs.getLong("ad_id"),
                rs.getBoolean("viewing_preference")
        );
    }
}
