package com.codeup.adlister.dao;

import com.codeup.adlister.models.UserEmail;

public interface UserEmails {
    UserEmail findByEmail(String email);
    UserEmail findByUserId(Long userId);
    Long insert(UserEmail userEmail);
}
