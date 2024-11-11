package com.virtualstore.virtualstore.services;
import java.util.Collection;

import com.virtualstore.virtualstore.entities.SubCategory;
public interface SubCategoryService {

    public abstract void createSubCategory(SubCategory subCategory);
    public abstract void updateSubCategory(Long id, SubCategory subCategory);
    public abstract void deleteSubCategory(Long id);
    public abstract Collection<SubCategory> getSubCategories();
    public abstract SubCategory getSubCategory(Long id);
    public abstract SubCategory getCategoryByName(String name);
    
}
