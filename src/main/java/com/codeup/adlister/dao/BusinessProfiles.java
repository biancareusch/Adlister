package com.codeup.adlister.dao;

import com.codeup.adlister.models.BusinessProfile;

public interface BusinessProfiles {
    BusinessProfile findByBusinessId(long businessId);
    Long insert(BusinessProfile id);
}
