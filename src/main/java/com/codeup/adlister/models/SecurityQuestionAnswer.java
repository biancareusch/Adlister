package com.codeup.adlister.models;

public class SecurityQuestionAnswer {
    private long questionId;
    private long answerId;

    public SecurityQuestionAnswer(){}

    public SecurityQuestionAnswer(long questionId, long answerId) {
        this.questionId = questionId;
        this.answerId = answerId;
    }

    public long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }

    public long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(long answerId) {
        this.answerId = answerId;
    }
}
