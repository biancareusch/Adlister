package com.codeup.adlister.models;

import com.codeup.adlister.util.Password;

public class User {
    private long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Boolean isAdmin;


    public User() {}

    public User(String username, String email, String password,String first_name,String last_name) {
        this.username = username;
        this.email = email;
        setPassword(password);
        this.firstName = first_name;
        this.lastName = last_name;
        this.isAdmin = false;
    }

    public User(long id, String username, String email, String password, String first_name, String last_name) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = first_name;
        this.lastName = last_name;
        this.isAdmin = false;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String first_name){
        this.firstName = first_name;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String last_name){
        this.lastName = last_name;
    }
    public Boolean isAdmin(){
        return this.isAdmin;
    }
    public void setAsAdmin(Boolean isAdmin){
        this.isAdmin = isAdmin;
    }
}
