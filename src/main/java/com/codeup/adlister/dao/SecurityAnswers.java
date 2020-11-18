package com.codeup.adlister.dao;

import com.codeup.adlister.models.SecurityAnswer;

public interface SecurityAnswers {
    SecurityAnswer findByUserId (long userId);
    SecurityAnswer findByBusinessId (long businessId);
    SecurityAnswer findByAnswer (String answer);
    Long insert(SecurityAnswer id);
}
