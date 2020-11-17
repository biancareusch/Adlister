package com.codeup.adlister.models;

public class Lister {
    private long userId;
    private long businessId;

    public Lister(){}

    public Lister(long userId, long businessId) {
        this.userId = userId;
        this.businessId = businessId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(long businessId) {
        this.businessId = businessId;
    }
}
