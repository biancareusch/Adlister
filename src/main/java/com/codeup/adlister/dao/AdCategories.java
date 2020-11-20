package com.codeup.adlister.dao;

import com.codeup.adlister.models.AdCategory;

public interface AdCategories {
    AdCategory findByCategoryName(String categoryName);
}
