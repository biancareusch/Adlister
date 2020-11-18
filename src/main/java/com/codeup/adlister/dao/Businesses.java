package com.codeup.adlister.dao;

import com.codeup.adlister.models.Business;

public interface Businesses {
    Business findByBusinessName(String businessName);
    Business findByBusinessID(Long businessID);
    Long insert(Business business);
}
