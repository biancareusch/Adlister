package com.codeup.adlister.models;

public class SecurityQuestion {
    private long id;
    private long userId;
    private String questions;
    private long businessId;

    public SecurityQuestion() {}

    public SecurityQuestion(long userId, String questions, long businessId) {
        this.userId = userId;
        this.questions = questions;
        this.businessId = businessId;
    }

    public SecurityQuestion(long id, long userId, String questions, long businessId) {
        this.id = id;
        this.userId = userId;
        this.questions = questions;
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

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    public long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(long businessId) {
        this.businessId = businessId;
    }
}
