package com.codeup.adlister.models;

public class BusinessEmail {
    private long id;
    private long businessId;
    private String email;
    private String username;

    public BusinessEmail(){}

    public BusinessEmail(long businessId, String email, String username) {
        this.businessId = businessId;
        this.email = email;
        this.username = username;
    }

    public BusinessEmail(long id, long businessId, String email, String username) {
        this.id = id;
        this.businessId = businessId;
        this.email = email;
        this.username = username;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(long businessId) {
        this.businessId = businessId;
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
