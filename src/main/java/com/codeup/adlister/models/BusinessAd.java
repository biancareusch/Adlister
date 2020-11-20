package com.codeup.adlister.models;

public class BusinessAd {
    private long id;
    private long businessId;
    private String title;
    private String description;
    private String createTime;


    public BusinessAd(){}

    public BusinessAd(long businessId, String title, String description) {
        this.businessId = businessId;
        this.title = title;
        this.description = description;
    }

    public BusinessAd(long id, long businessId, String title, String description) {
        this.id = id;
        this.businessId = businessId;
        this.title = title;
        this.description = description;
    }

    public BusinessAd(long id, long businessId, String title, String description, String createTime) {
        this.id = id;
        this.businessId = businessId;
        this.title = title;
        this.description = description;
        this.createTime = createTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(long businessId) {
        this.businessId = businessId;
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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
