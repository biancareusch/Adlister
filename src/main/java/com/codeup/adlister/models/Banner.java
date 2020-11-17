package com.codeup.adlister.models;

public class Banner {
    private long id;
    private String title;
    private String description;
    private String url;
    private long adId;

    //Constructors
    public Banner (){}

    public Banner (String aTitle, String aDescription, String aUrl, long aAdId){
        this.title = aTitle;
        this.description = aDescription;
        this.url = aUrl;
        this.adId = aAdId;
    }

    public Banner (long aId, String aTitle, String aDescription, String aUrl, long aAdId){
        this.id = aId;
        this.title = aTitle;
        this.description = aDescription;
        this.url = aUrl;
        this.adId = aAdId;
    }

    //getters and setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getAdId() {
        return adId;
    }

    public void setAdId(long adId) {
        this.adId = adId;
    }
}
