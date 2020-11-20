package com.codeup.adlister.models;

public class BusinessAdPicture {
    private long id;
    private String businessAdImgUrl;
    private String altText;
    private long businessAdId;
    private String createTime;

    public BusinessAdPicture(){}

    public BusinessAdPicture(String businessAdImgUrl, String altText) {
        this.businessAdImgUrl = businessAdImgUrl;
        this.altText = altText;
    }

    public BusinessAdPicture(String businessAdImgUrl, String altText, long businessAdId) {
        this.businessAdImgUrl = businessAdImgUrl;
        this.altText = altText;
        this.businessAdId = businessAdId;
    }

    public BusinessAdPicture(String businessAdImgUrl, String altText, long businessAdId, String createTime) {
        this.businessAdImgUrl = businessAdImgUrl;
        this.altText = altText;
        this.businessAdId = businessAdId;
        this.createTime = createTime;
    }

    public BusinessAdPicture(long id, String businessAdImgUrl, String altText, long businessAdId, String createTime) {
        this.id = id;
        this.businessAdImgUrl = businessAdImgUrl;
        this.altText = altText;
        this.businessAdId = businessAdId;
        this.createTime = createTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBusinessAdImgUrl() {
        return businessAdImgUrl;
    }

    public void setBusinessAdImgUrl(String businessAdImgUrl) {
        this.businessAdImgUrl = businessAdImgUrl;
    }

    public String getAltText() {
        return altText;
    }

    public void setAltText(String altText) {
        this.altText = altText;
    }

    public long getBusinessAdId() {
        return businessAdId;
    }

    public void setBusinessAdId(long businessAdId) {
        this.businessAdId = businessAdId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
