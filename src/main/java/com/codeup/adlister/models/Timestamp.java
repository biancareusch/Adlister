package com.codeup.adlister.models;

public class Timestamp {
    private String createTime;
    private String updateTime;
    private long id;

    public Timestamp(){}

    public Timestamp(String createTime, String updateTime) {
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Timestamp(String createTime, String updateTime, long id) {
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.id = id;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
