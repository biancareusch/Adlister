package com.codeup.adlister.models;

public class AdPicture {
    private long id;
    private long adId;
    private String url;

    public AdPicture(){}

    public AdPicture(long adId, String url) {
        this.adId = adId;
        this.url = url;
    }

    public AdPicture(long id, long adId, String url) {
        this.id = id;
        this.adId = adId;
        this.url = url;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAdId() {
        return adId;
    }

    public void setAdId(long adId) {
        this.adId = adId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
