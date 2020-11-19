package com.codeup.adlister.dao;

import com.codeup.adlister.models.SecurityAnswer;
import com.mysql.cj.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.*;

public class MySQLSecurityAnswersDao implements SecurityAnswers{
    private Connection connection;

    public MySQLSecurityAnswersDao(Config config) {
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
    public SecurityAnswer findByUserId (long userId){
        String query = "SELECT * FROM security_answers WHERE user_id = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            String searchID = String.valueOf(userId);
            stmt.setString(1, searchID);
            return extractSecurityAnswer(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a security answers by user_id", e);
        }
    };

    @Override
    public SecurityAnswer findByBusinessId (long businessId){
        String query = "SELECT * FROM security_answers WHERE business_id = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            String searchID = String.valueOf(businessId);
            stmt.setString(1, searchID);
            return extractSecurityAnswer(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a security answer by business_id", e);
        }
    };

    @Override
    public SecurityAnswer findByAnswer (String answer){
        String query = "SELECT * FROM security_answers WHERE answers = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, answer);
            return extractSecurityAnswer(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding an security answer by answer", e);
        }
    };

    @Override
    public Long insert(SecurityAnswer securityAnswer){
        String query = "INSERT INTO security_answers(user_id, answers, business_id) VALUES (?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, securityAnswer.getUserId());
            stmt.setString(2, securityAnswer.getAnswers());
            stmt.setLong(2, securityAnswer.getBusinessId());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating new security answer", e);
        }
    };

//    @Override
//    public Long insertUserSecurityAnswer(SecurityAnswer securityAnswer){
//        String query = "INSERT INTO security_answers(answers, business_id) VALUES (?, ?)";
//        try {
//            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
//            stmt.setLong(1, securityAnswer.getUserId());
//            stmt.setString(2, securityAnswer.getQuestions());
//            stmt.executeUpdate();
//            ResultSet rs = stmt.getGeneratedKeys();
//            rs.next();
//            return rs.getLong(1);
//        } catch (SQLException e) {
//            throw new RuntimeException("Error creating new security answer", e);
//        }
//    };
//
//    @Override
//    public Long insertBusinessSecurityAnswer(SecurityAnswer securityAnswer){
//        String query = "INSERT INTO security_answers(answers, business_id) VALUES (?, ?)";
//        try {
//            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
//            stmt.setString(1, securityAnswer.getQuestions());
//            stmt.setLong(2, securityAnswer.getBusinessId());
//            stmt.executeUpdate();
//            ResultSet rs = stmt.getGeneratedKeys();
//            rs.next();
//            return rs.getLong(1);
//        } catch (SQLException e) {
//            throw new RuntimeException("Error creating new security answer", e);
//        }
//    };


    private SecurityAnswer extractSecurityAnswer(ResultSet rs) throws SQLException {
        if (! rs.next()) {
            return null;
        }
        return new SecurityAnswer(
                rs.getLong("id"),
                rs.getLong("user_id"),
                rs.getString("answers"),
                rs.getLong("business_id")
        );
    }
}
