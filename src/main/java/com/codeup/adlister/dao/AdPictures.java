package com.codeup.adlister.dao;

import com.codeup.adlister.models.AdPicture;

public interface AdPictures {
    AdPicture findByPicID(long picId);
    Long insertPic(AdPicture id);
}
