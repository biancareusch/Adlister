package com.codeup.adlister.models;

public class BusinessPicture {
    private long id;
    private String name;
    private String title;
    private String url;
    private long businessId;

    public BusinessPicture(){}

    public BusinessPicture(String name, String title, String url, long businessId) {
        this.name = name;
        this.title = title;
        this.url = url;
        this.businessId = businessId;
    }

    public BusinessPicture(long id, String name, String title, String url, long businessId) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.url = url;
        this.businessId = businessId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(long businessId) {
        this.businessId = businessId;
    }
}
