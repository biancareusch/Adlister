package com.codeup.adlister.models;

public class AdPicture {
    private long id;
    private String url;
    private String alt_text;
    private long adID;


    public AdPicture(){}

    public AdPicture( String url, String alt_text, long adID) {
        this.url = url;
        this.alt_text = alt_text;
        this.adID = adID;
    }

    public AdPicture(long id, String url, String alt_text, long adID) {
        this.id = id;
        this.url = url;
        this.alt_text = alt_text;
        this.adID = adID;

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

    public String getAltText(){
        return this.alt_text;
    }
}
