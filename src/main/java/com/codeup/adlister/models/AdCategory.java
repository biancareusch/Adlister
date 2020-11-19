package com.codeup.adlister.models;

public class AdCategory {
    private long adId;
    private long categoryId;
    private String categoryName;
    private String adTitle;
    private String adDescription;

    public AdCategory(){}

    public AdCategory(String categoryName, String adTitle, String adDescription) {
        this.categoryName = categoryName;
        this.adTitle = adTitle;
        this.adDescription = adDescription;
    }

    public AdCategory(long adId, long categoryId, String categoryName, String adTitle, String adDescription) {
        this.adId = adId;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.adTitle = adTitle;
        this.adDescription = adDescription;
    }

    public long getAdId() {
        return adId;
    }

    public void setAdId(long adId) {
        this.adId = adId;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getAdTitle() {
        return adTitle;
    }

    public void setAdTitle(String adTitle) {
        this.adTitle = adTitle;
    }

    public String getAdDescription() {
        return adDescription;
    }

    public void setAdDescription(String adDescription) {
        this.adDescription = adDescription;
    }
}
