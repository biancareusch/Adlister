package com.codeup.adlister.models;

public class SecurityAnswer {
    private long id;
    private long userId;
    private String answers;
    private long businessId;

    public SecurityAnswer(){}

    public SecurityAnswer(long userId, String answers, long businessId) {
        this.userId = userId;
        this.answers = answers;
        this.businessId = businessId;
    }

    public SecurityAnswer(long id, long userId, String answers, long businessId) {
        this.id = id;
        this.userId = userId;
        this.answers = answers;
        this.businessId = businessId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getAnswers() {
        return answers;
    }

    public void setAnswers(String answers) {
        this.answers = answers;
    }

    public long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(long businessId) {
        this.businessId = businessId;
    }
}
