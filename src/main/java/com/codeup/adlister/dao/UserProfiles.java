package com.codeup.adlister.dao;

import com.codeup.adlister.models.UserProfile;

public interface UserProfiles {
    UserProfile findByUserId(long userId);
    Long insert(UserProfile id);
}
