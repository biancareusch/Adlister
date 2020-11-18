package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.AdPicture;
import com.codeup.adlister.models.BusinessPicture;

public interface BusinessPictures {
    BusinessPicture findByURL(String url);
    BusinessPicture findByBusinessID();
    Long insert(BusinessPicture id);
}
