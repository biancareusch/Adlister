package com.codeup.adlister.dao;

import com.codeup.adlister.models.Admin;

public interface Admins {
    Admin findByEmail(String email);
    Admin findByAdminID(Long adminID);
    Long insert(Admin admin);
}
