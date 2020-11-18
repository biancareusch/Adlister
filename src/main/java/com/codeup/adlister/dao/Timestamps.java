package com.codeup.adlister.dao;

import com.codeup.adlister.models.Timestamp;

public interface Timestamps {
    Timestamp findByUserId (long userId);
    Timestamp findByBusinessId (long businessId);
}
