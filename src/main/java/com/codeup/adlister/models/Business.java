package com.codeup.adlister.models;

import com.codeup.adlister.util.Password;

public class Business {
    private long id;
    private String businessName;
    private String address;
    private String email;
    private String password;
    private Boolean isAdmin;
    //private long addressId;

    //Constructors

    //Anything
    public Business(){}

    //SELECT
    public Business(long aId, String aBusinessName, String aEmail, String aPassword, Boolean aIsAdmin){
        this.id = aId;
        this.businessName = aBusinessName;
        this.email = aEmail;
        this.password = aPassword;
        this.isAdmin = aIsAdmin;
        //this.addressId = aAddressID;
    }

    //INSERT
    public Business(String aBusinessName, String aEmail, String aPassword, Boolean aIsAdmin){
        this.businessName = aBusinessName;
        this.email = aEmail;
        this.password = aPassword;
        this.isAdmin = aIsAdmin;
        //this.addressId = aAddressID;
    }

    //getters & setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
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
        this.password = Password.hash(password);
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

//    public long getAddressId() {
//        return addressId;
//    }
//
//    public void setAddressId(long addressId) {
//        this.addressId = addressId;
//    }
}
