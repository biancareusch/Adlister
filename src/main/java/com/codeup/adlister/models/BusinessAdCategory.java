package com.codeup.adlister.models;

public class BusinessAdCategory {
    private long businessAdId;
    private long businessCategoryId;
    private String businessCategoryName;
    private String businessAdTitle;
    private String businessAdDescription;

    public BusinessAdCategory(){}

    public BusinessAdCategory(String businessCategoryName, String businessAdTitle, String businessAdDescription) {
        this.businessCategoryName = businessCategoryName;
        this.businessAdTitle = businessAdTitle;
        this.businessAdDescription = businessAdDescription;
    }

    public BusinessAdCategory(long businessAdId, long businessCategoryId, String businessCategoryName, String businessAdTitle, String businessAdDescription) {
        this.businessAdId = businessAdId;
        this.businessCategoryId = businessCategoryId;
        this.businessCategoryName = businessCategoryName;
        this.businessAdTitle = businessAdTitle;
        this.businessAdDescription = businessAdDescription;
    }

    public long getBusinessAdId() {
        return businessAdId;
    }

    public void setBusinessAdId(long businessAdId) {
        this.businessAdId = businessAdId;
    }

    public long getBusinessCategoryId() {
        return businessCategoryId;
    }

    public void setBusinessCategoryId(long businessCategoryId) {
        this.businessCategoryId = businessCategoryId;
    }

    public String getBusinessCategoryName() {
        return businessCategoryName;
    }

    public void setBusinessCategoryName(String businessCategoryName) {
        this.businessCategoryName = businessCategoryName;
    }

    public String getBusinessAdTitle() {
        return businessAdTitle;
    }

    public void setBusinessAdTitle(String businessAdTitle) {
        this.businessAdTitle = businessAdTitle;
    }

    public String getBusinessAdDescription() {
        return businessAdDescription;
    }

    public void setBusinessAdDescription(String businessAdDescription) {
        this.businessAdDescription = businessAdDescription;
    }

}
