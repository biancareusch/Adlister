package com.codeup.adlister.dao;

import com.codeup.adlister.models.AdPicture;
import com.mysql.cj.api.mysqla.result.Resultset;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class MySQLadPicDao implements AdPictures{
    private Connection connection;

    public MySQLadPicDao(Config config) {
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
    public AdPicture findByURL(String URL) {
        String query = "SELECT * FROM ad_pictures WHERE ad_img_url = ?";
        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, URL);
            return extractPic(stmt.executeQuery());
        }catch (SQLException e){
            throw new RuntimeException("Error finding a picture by URL");
        }
    }

    @Override
    public AdPicture findByadIDAds(long UserID) {
        String query = "SELECT * FROM ad_pictures WHERE ad_id = ?";
        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            String searchID = String.valueOf(UserID);
            stmt.setString(1, searchID);
            return extractPic(stmt.executeQuery());
        }catch (SQLException e){
            throw new RuntimeException("Error finding a picture by userID");
        }
    }

    @Override
    public AdPicture findByAdID(long adID) {
        String query = "SELECT * FROM ad_pictures WHERE id = ?";
        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            String searchID = String.valueOf(adID);
            stmt.setString(1, searchID);
            return extractPic(stmt.executeQuery());
        }catch (SQLException e){
            throw new RuntimeException("Error finding a picture by ad ID");
        }
    }

    @Override
    public Long insert(AdPicture adPic) {
        String query = "INSERT INTO ad_pictures(id, ad_img_url,alt_text,ad_id) VALUES (?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            String idString = String.valueOf(adPic.getId());
            stmt.setString(1,idString );
            stmt.setString(2, adPic.getAdImgUrl());
            stmt.setString(3, adPic.getAltText());
            stmt.setLong(4, adPic.getAdId());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error adding ad picture", e);
        }
    }

    public void updatePicURL(String newPicURL, long adID) {
        String query = "UPDATE ad_pictures  SET ad_img_url = ? WHERE ad_id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, newPicURL);
            stmt.setLong(2, adID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating a picture by User ID", e);
        }
    }

    private AdPicture extractPic(ResultSet rs) throws SQLException {
        if(!rs.next()){
            return null;
        }
        return new AdPicture(
                rs.getLong("id"),
                rs.getString("URL"),
                rs.getString("alt_text"),
                rs.getLong("ad_id"),
                rs.getString("create_time")
        );
    }

}
