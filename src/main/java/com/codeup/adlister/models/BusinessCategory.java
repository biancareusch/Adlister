package com.codeup.adlister.models;

public class BusinessCategory {
    private long id;
    private long businessAdId;
    private String name;

    public BusinessCategory () {}

    public BusinessCategory(long businessAdId, String name) {
        this.businessAdId = businessAdId;
        this.name = name;
    }

    public BusinessCategory(long id, long businessAdId, String name) {
        this.id = id;
        this.businessAdId = businessAdId;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getBusinessAdId() {
        return businessAdId;
    }

    public void setBusinessAdId(long businessAdId) {
        this.businessAdId = businessAdId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
