package com.codeup.adlister.dao;

import com.codeup.adlister.models.BusinessPicture;

public interface BusinessPictures {
    BusinessPicture findByPicID(long picId);
    Long insertPic(BusinessPicture businessPicture);
}
