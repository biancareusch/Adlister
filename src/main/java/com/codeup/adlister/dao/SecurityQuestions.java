package com.codeup.adlister.dao;

import com.codeup.adlister.models.SecurityQuestion;

public interface SecurityQuestions {
    SecurityQuestion findByUserId (long userId);
    SecurityQuestion findByBusinessId (long businessId);
    SecurityQuestion findByQuestion (String question);
    Long insert(SecurityQuestion securityQuestion);
}
