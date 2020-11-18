package com.codeup.adlister.models;

public class UserTimestamp {
    private long userId;
    private long timestampId;

    public UserTimestamp(){}

    public UserTimestamp(long userId, long timestampId) {
        this.userId = userId;
        this.timestampId = timestampId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getTimestampId() {
        return timestampId;
    }

    public void setTimestampId(long timestampId) {
        this.timestampId = timestampId;
    }
}
