package com.codeup.adlister.models;

public class AdPicture {
    private long id;
    private String adImgUrl;
    private String altText;
    private long adId;
    private String createTime;

    public AdPicture(){}

    public AdPicture(String adImgUrl, String altText) {
        this.adImgUrl = adImgUrl;
        this.altText = altText;
    }

    public AdPicture(String adImgUrl, String altText, long adId) {
        this.adImgUrl = adImgUrl;
        this.altText = altText;
        this.adId = adId;
    }

    public AdPicture(String adImgUrl, String altText, long adId, String createTime) {
        this.adImgUrl = adImgUrl;
        this.altText = altText;
        this.adId = adId;
        this.createTime = createTime;
    }

    public AdPicture(long id, String adImgUrl, String altText, long adId, String createTime) {
        this.id = id;
        this.adImgUrl = adImgUrl;
        this.altText = altText;
        this.adId = adId;
        this.createTime = createTime;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAdImgUrl() {
        return adImgUrl;
    }

    public void setAdImgUrl(String adImgUrl) {
        this.adImgUrl = adImgUrl;
    }

    public String getAltText() {
        return altText;
    }

    public void setAltText(String altText) {
        this.altText = altText;
    }

    public long getAdId() {
        return adId;
    }

    public void setAdId(long adId) {
        this.adId = adId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
