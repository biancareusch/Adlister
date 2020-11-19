package com.codeup.adlister.dao;

import com.codeup.adlister.models.AdPicture;
import com.codeup.adlister.models.BusinessAdPicture;

public interface BusinessAdPictures {
    BusinessAdPicture findByPicID(long picId);
    Long insertPic(BusinessAdPicture id);
}
