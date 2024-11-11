package com.virtualstore.virtualstore.services;

import java.util.Collection;

import com.virtualstore.virtualstore.entities.Category;

public interface CategoryService {

    public abstract void createCategory(Category category);
    public abstract void updateCategory(Long id, Category category);
    public abstract void deleteCategory(Long id);
    public abstract Collection<Category> getCategories();
    public abstract Category getCategory(Long id);
    public abstract Category getCategoryByName(String name);

    
} 