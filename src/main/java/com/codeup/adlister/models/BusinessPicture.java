package com.codeup.adlister.models;

public class BusinessPicture {
    private long id;
    private String businessImgUrl;
    private String altText;
    private long businessId;
    private String createTime;


    public BusinessPicture(){}

    public BusinessPicture(String businessImgUrl) {
        this.businessImgUrl = businessImgUrl;
    }

    public BusinessPicture(String businessImgUrl, String altText) {
        this.businessImgUrl = businessImgUrl;
        this.altText = altText;
    }

    public BusinessPicture(long id, String businessImgUrl) {
        this.id = id;
        this.businessImgUrl = businessImgUrl;
    }

    public BusinessPicture(String businessImgUrl, String altText, long businessId) {
        this.businessImgUrl = businessImgUrl;
        this.altText = altText;
        this.businessId = businessId;
    }

    public BusinessPicture(long id, String businessImgUrl, String altText, long businessId) {
        this.id = id;
        this.businessImgUrl = businessImgUrl;
        this.altText = altText;
        this.businessId = businessId;
    }

    public BusinessPicture(long id, String businessImgUrl, String altText, long businessId, String createTime) {
        this.id = id;
        this.businessImgUrl = businessImgUrl;
        this.altText = altText;
        this.businessId = businessId;
        this.createTime = createTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBusinessImgUrl() {
        return businessImgUrl;
    }

    public void setBusinessImgUrl(String businessImgUrl) {
        this.businessImgUrl = businessImgUrl;
    }

    public String getAltText() {
        return altText;
    }

    public void setAltText(String altText) {
        this.altText = altText;
    }

    public long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(long businessId) {
        this.businessId = businessId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
