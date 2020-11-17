package com.codeup.adlister.models;

public class UserEmail {
    private long id;
    private long userId;
    private String email;
    private String username;

    public UserEmail(){}

    public UserEmail(long userId, String email, String username) {
        this.userId = userId;
        this.email = email;
        this.username = username;
    }

    public UserEmail(long id, long userId, String email, String username) {
        this.id = id;
        this.userId = userId;
        this.email = email;
        this.username = username;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
