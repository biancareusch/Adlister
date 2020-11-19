package com.codeup.adlister.dao;

import com.codeup.adlister.models.SecurityQuestion;
import com.mysql.cj.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.*;

public class MySQLSecurityQuestionsDao implements SecurityQuestions{
    private Connection connection;

    public MySQLSecurityQuestionsDao(Config config) {
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
    public SecurityQuestion findByUserId (long userId){
        String query = "SELECT * FROM security_questions WHERE user_id = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            String searchID = String.valueOf(userId);
            stmt.setString(1, searchID);
            return extractSecurityQuestion(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a security questions by user_id", e);
        }
    };

    @Override
    public SecurityQuestion findByBusinessId (long businessId){
        String query = "SELECT * FROM security_questions WHERE business_id = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            String searchID = String.valueOf(businessId);
            stmt.setString(1, searchID);
            return extractSecurityQuestion(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a security question by business_id", e);
        }
    };

    @Override
    public SecurityQuestion findByQuestion (String question){
        String query = "SELECT * FROM security_questions WHERE questions = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, question);
            return extractSecurityQuestion(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding an security question by question", e);
        }
    };

    @Override
    public Long insert(SecurityQuestion securityQuestion){
        String query = "INSERT INTO security_questions(user_id, questions, business_id) VALUES (?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, securityQuestion.getUserId());
            stmt.setString(2, securityQuestion.getQuestions());
            stmt.setLong(2, securityQuestion.getBusinessId());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating new security question", e);
        }
    };

//    @Override
//    public Long insertUserSecurityQuestion(SecurityQuestion securityQuestion){
//        String query = "INSERT INTO security_questions(user_id, questions) VALUES (?, ?)";
//        try {
//            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
//            stmt.setLong(1, securityQuestion.getUserId());
//            stmt.setString(2, securityQuestion.getQuestions());
//            stmt.executeUpdate();
//            ResultSet rs = stmt.getGeneratedKeys();
//            rs.next();
//            return rs.getLong(1);
//        } catch (SQLException e) {
//            throw new RuntimeException("Error creating new security question", e);
//        }
//    };
//
//    @Override
//    public Long insertBusinessSecurityQuestion(SecurityQuestion securityQuestion){
//        String query = "INSERT INTO security_questions(questions, business_id) VALUES (?, ?)";
//        try {
//            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
//            stmt.setString(1, securityQuestion.getQuestions());
//            stmt.setLong(2, securityQuestion.getBusinessId());
//            stmt.executeUpdate();
//            ResultSet rs = stmt.getGeneratedKeys();
//            rs.next();
//            return rs.getLong(1);
//        } catch (SQLException e) {
//            throw new RuntimeException("Error creating new security question", e);
//        }
//    };

    private SecurityQuestion extractSecurityQuestion(ResultSet rs) throws SQLException {
        if (! rs.next()) {
            return null;
        }
        return new SecurityQuestion(
                rs.getLong("id"),
                rs.getLong("user_id"),
                rs.getString("questions"),
                rs.getLong("business_id")
        );
    }
}
