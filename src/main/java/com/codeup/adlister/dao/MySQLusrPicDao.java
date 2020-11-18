package com.codeup.adlister.dao;

import com.codeup.adlister.models.UserPicture;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class MySQLusrPicDao implements UserPictures {
    private Connection connection;

    public MySQLusrPicDao(Config config) {
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
    public UserPicture findByPicID(long picID) {
        String query = "SELECT * FROM user_pictures WHERE id = ? LIMIT 1";
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
    public Long insertPic(UserPicture userPic) {
        String query = "INSERT INTO user_pictures(imgURL) VALUES (?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, userPic.getImgURL());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating new user", e);
        }
    }

    private UserPicture extractPic(ResultSet rs) throws SQLException {
        if (! rs.next()) {
            return null;
        }
        return new UserPicture(
                rs.getLong("id"),
                rs.getString("imgURL")
        );
    }
}
