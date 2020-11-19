package com.codeup.adlister.dao;

import com.codeup.adlister.models.Admin;
import com.mysql.cj.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.*;

public class MySQLAdminsDao implements Admins{
    private Connection connection;

    public MySQLAdminsDao(Config config) {
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
    public Admin findByEmail(String email){
        String query = "SELECT * FROM admin WHERE email = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, email);
            return extractAdmin(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding an admin by email", e);
        }
    };

    @Override
    public Admin findByAdminID(Long adminID){
        String query = "SELECT * FROM admin WHERE id = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            String searchID = String.valueOf(adminID);
            stmt.setString(1, searchID);
            return extractAdmin(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding an admin by id", e);
        }
    };

    @Override
    public Long insert(Admin admin){
        String query = "INSERT INTO admin(email, password) VALUES (?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, admin.getEmail());
            stmt.setString(2, admin.getPassword());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating new admin", e);
        }
    };

    private Admin extractAdmin(ResultSet rs) throws SQLException {
        if (! rs.next()) {
            return null;
        }
        return new Admin(
                rs.getLong("id"),
                rs.getString("email"),
                rs.getString("password")
        );
    }


}
