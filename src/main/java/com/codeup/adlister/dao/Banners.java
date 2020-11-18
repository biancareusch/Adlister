package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Banner;

public interface Banners {
    Banner findByURL();
    Banner findByUserID();
    Banner findByAdID();
    Long insert(Ad id);
}
