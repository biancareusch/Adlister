package com.codeup.adlister.dao;

import com.codeup.adlister.models.BusinessCategory;
import java.util.List;

public interface BusinessCategories {
    List<BusinessCategory> all();
    BusinessCategory findByCategoryId(Long categoryId);
    Long insert(BusinessCategory businessCategory);
}
