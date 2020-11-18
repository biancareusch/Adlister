package com.codeup.adlister.models;

public class Admin {
    private long id;
    private String email;
    private String password;

    public Admin(){}

    public Admin(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Admin(long id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
