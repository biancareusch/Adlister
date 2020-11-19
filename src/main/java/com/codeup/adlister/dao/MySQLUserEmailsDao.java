package com.codeup.adlister.dao;

import com.codeup.adlister.models.BusinessEmail;
import com.codeup.adlister.models.UserEmail;
import com.mysql.cj.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.*;

public class MySQLUserEmailsDao implements UserEmails{
    private Connection connection;

    public MySQLUserEmailsDao(Config config) {
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
    public UserEmail findByEmail(String email){
        String query = "SELECT * FROM user_emails WHERE email = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, email);
            return extractUserEmail(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding an user by email", e);
        }
    };

    @Override
    public UserEmail findByUserId(Long userId){
        String query = "SELECT * FROM user_emails WHERE user_id = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            String searchID = String.valueOf(userId);
            stmt.setString(1, searchID);
            return extractUserEmail(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a user by user_id", e);
        }
    };

    @Override
    public Long insert(UserEmail userEmail){
        String query = "INSERT INTO user_emails(user_id, email, username) VALUES (?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, userEmail.getUserId());
            stmt.setString(2, userEmail.getEmail());
            stmt.setString(3, userEmail.getUsername());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating new userEmail", e);
        }
    };

    private UserEmail extractUserEmail(ResultSet rs) throws SQLException {
        if (! rs.next()) {
            return null;
        }
        return new UserEmail(
                rs.getLong("id"),
                rs.getLong("user_id"),
                rs.getString("email"),
                rs.getString("username")
        );
    }
}
