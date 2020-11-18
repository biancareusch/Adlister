package com.codeup.adlister.models;

public class AdTimestamp {
    private long adId;
    private long timestampId;

    public AdTimestamp(){}

    public AdTimestamp(long adId, long timestampId) {
        this.adId = adId;
        this.timestampId = timestampId;
    }

    public long getAdId() {
        return adId;
    }

    public void setAdId(long adId) {
        this.adId = adId;
    }

    public long getTimestampId() {
        return timestampId;
    }

    public void setTimestampId(long timestampId) {
        this.timestampId = timestampId;
    }
}
