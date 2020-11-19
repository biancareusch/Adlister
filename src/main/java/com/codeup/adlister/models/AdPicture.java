package com.codeup.adlister.models;

public class AdPicture {
    private long id;
    private long adID;
    private String url;

    public AdPicture(){}

    public AdPicture(long adID, String url) {
        this.adID = adID;
        this.url = url;
    }

    public AdPicture(long id, long userID, String url) {
        this.id = id;
        this.adID = userID;
        this.url = url;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAdId() {
        return adID;
    }

    public void setAdId(long adId) {
        this.adID = adId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
