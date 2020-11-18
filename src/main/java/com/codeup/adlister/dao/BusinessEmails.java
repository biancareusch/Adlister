package com.codeup.adlister.dao;

import com.codeup.adlister.models.BusinessEmail;

public interface BusinessEmails {
    BusinessEmail findByEmail(String email);
    BusinessEmail findByBusinessId(Long businessId);
    Long insert(BusinessEmail businessEmail);
}
