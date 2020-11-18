package com.codeup.adlister.dao;

import com.codeup.adlister.models.UserProfile;

public interface UserProfiles {
    UserProfile findByUserId(long userId);
    UserProfile findByUsername (String username);
    Long insert(UserProfile id);
}
