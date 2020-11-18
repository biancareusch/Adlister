package com.codeup.adlister.models;

public class BusinessTimestamp {
    private long businessId;
    private long timestampId;

    public BusinessTimestamp(){}

    public BusinessTimestamp(long businessId, long timestampId) {
        this.businessId = businessId;
        this.timestampId = timestampId;
    }

    public long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(long businessId) {
        this.businessId = businessId;
    }

    public long getTimestampId() {
        return timestampId;
    }

    public void setTimestampId(long timestampId) {
        this.timestampId = timestampId;
    }
}
