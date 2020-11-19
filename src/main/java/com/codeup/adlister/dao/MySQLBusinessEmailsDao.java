package com.codeup.adlister.dao;

import com.codeup.adlister.models.BusinessEmail;
import com.mysql.cj.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.*;

public class MySQLBusinessEmailsDao implements BusinessEmails{
    private Connection connection;

    public MySQLBusinessEmailsDao(Config config) {
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
    public BusinessEmail findByEmail(String email){
        String query = "SELECT * FROM business_emails WHERE email = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, email);
            return extractBusinessEmail(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding an business by email", e);
        }
    };

    @Override
    public BusinessEmail findByBusinessId(Long businessId){
        String query = "SELECT * FROM business_emails WHERE business_id = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            String searchID = String.valueOf(businessId);
            stmt.setString(1, searchID);
            return extractBusinessEmail(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a business by business_id", e);
        }
    };

    @Override
    public Long insert(BusinessEmail businessEmail){
        String query = "INSERT INTO business_emails(business_id, email, username) VALUES (?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, businessEmail.getBusinessId());
            stmt.setString(2, businessEmail.getEmail());
            stmt.setString(3, businessEmail.getUsername());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating new businessEmail", e);
        }
    };

    private BusinessEmail extractBusinessEmail(ResultSet rs) throws SQLException {
        if (! rs.next()) {
            return null;
        }
        return new BusinessEmail(
                rs.getLong("id"),
                rs.getLong("business_id"),
                rs.getString("email"),
                rs.getString("username")
        );
    }


}
