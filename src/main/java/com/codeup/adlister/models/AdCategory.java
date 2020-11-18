package com.codeup.adlister.models;

public class AdCategory {
    private long categoryId;
    private long adId;

    public AdCategory(){}

    public AdCategory(long categoryId, long adId) {
        this.categoryId = categoryId;
        this.adId = adId;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public long getAdId() {
        return adId;
    }

    public void setAdId(long adId) {
        this.adId = adId;
    }
}
