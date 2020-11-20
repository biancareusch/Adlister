package com.codeup.adlister.dao;

import com.codeup.adlister.models.BusinessAdCategory;

public interface BusinessAdCategories {
    BusinessAdCategory findByCategoryName(String categoryName);
}
