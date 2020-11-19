package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;

public interface Users {
    User findByUsername(String username);
    User findByUserID(Long userID);
    Long insert(User user);
    void update(User user);
}
