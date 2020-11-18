package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.AdPicture;

public interface AdPictures {
    AdPicture findByURL();
    AdPicture findByUserID();
    AdPicture findByAdID();
    Long insert(AdPicture id);
}
