package com.codeup.adlister.dao;

import com.codeup.adlister.models.BusinessPicture;

public interface BusinessPictures {
    BusinessPicture findByPicID(long picID);
    Long insertPic(BusinessPicture businessPicture);
    BusinessPicture findByPicBusinessID(long businessID);
    void updatePicURL(String newPicURL, long userID);
}
