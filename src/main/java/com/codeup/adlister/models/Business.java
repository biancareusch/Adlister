package com.codeup.adlister.models;

import com.codeup.adlister.util.Password;

public class Business {
    private long id;
    private boolean listerType;
    private String businessName;
    private String email;
    private String password;
    private String websiteUrl;
    private String aboutUs;
    private String phoneNumber;
    private boolean viewPreference;
    private boolean isAdmin;
    private String createTime;

    //Constructors

    //Anything
    public Business(){}

    public Business(String businessName, String email, String password) {
        this.businessName = businessName;
        this.email = email;
        setPassword(password);
    }

    public Business(long id, boolean listerType, String businessName, String email, String password) {
        this.id = id;
        this.listerType = listerType;
        this.businessName = businessName;
        this.email = email;
        setPassword(password);
    }

    public Business(long id, boolean listerType, String businessName, String email, String password, String websiteUrl, String aboutUs, String phoneNumber, boolean viewPreference, boolean isAdmin, String createTime) {
        this.id = id;
        this.listerType = listerType;
        this.businessName = businessName;
        this.email = email;
        setPassword(password);
        this.websiteUrl = websiteUrl;
        this.aboutUs = aboutUs;
        this.phoneNumber = phoneNumber;
        this.viewPreference = viewPreference;
        this.isAdmin = isAdmin;
        this.createTime = createTime;
    }

    //getters & setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isListerType() {
        return listerType;
    }

    public void setListerType(boolean listerType) {
        this.listerType = listerType;
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

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public String getAboutUs() {
        return aboutUs;
    }

    public void setAboutUs(String aboutUs) {
        this.aboutUs = aboutUs;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isViewPreference() {
        return viewPreference;
    }

    public void setViewPreference(boolean viewPreference) {
        this.viewPreference = viewPreference;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
