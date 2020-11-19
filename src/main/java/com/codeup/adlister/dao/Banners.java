package com.codeup.adlister.dao;

import com.codeup.adlister.models.Banner;

public interface Banners {
    Banner findById(long id);
    Banner findByUserID(long userId);
    Banner findByAdID(long adId);
    Long insert(Banner banner);
}
