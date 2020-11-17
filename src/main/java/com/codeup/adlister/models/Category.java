package com.codeup.adlister.models;

public class Category {
    private long id;
    private String name;
    private long adId;

    public Category () {}

    public Category(String name, long adId) {
        this.name = name;
        this.adId = adId;
    }

    public Category(long id, String name, long adId) {
        this.id = id;
        this.name = name;
        this.adId = adId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getAdId() {
        return adId;
    }

    public void setAdId(long adId) {
        this.adId = adId;
    }
}
