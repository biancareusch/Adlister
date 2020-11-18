package com.codeup.adlister.dao;

import com.codeup.adlister.models.BusinessProfile;

public interface BusinessProfiles {
    BusinessProfile findByBusinessId(long businessId);
    BusinessProfile findByBusinessName (String businessName);
    BusinessProfile findByWebsiteUrl(String url);
    Long insert(BusinessProfile id);
}
