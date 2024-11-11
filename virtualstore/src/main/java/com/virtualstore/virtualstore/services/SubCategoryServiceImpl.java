package com.virtualstore.virtualstore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collection;

import com.virtualstore.virtualstore.entities.SubCategory;
import com.virtualstore.virtualstore.repositories.SubCategoryRepository;

@Service
public class SubCategoryServiceImpl implements SubCategoryService {

    @Autowired
    private SubCategoryRepository subCategoryRepository;

    @Override
    public void createSubCategory(SubCategory subCategory) {
        subCategoryRepository.save(subCategory);
    }

    @Override
    public void updateSubCategory(Long id, SubCategory subCategory) {
        SubCategory subCategoryToUpdate = subCategoryRepository.findById(id).get();
        subCategoryToUpdate.setName(subCategory.getName());
        subCategoryToUpdate.setProducts(subCategory.getProducts());
        subCategoryRepository.save(subCategoryToUpdate);
    }

    @Override
    public void deleteSubCategory(Long id) {
        subCategoryRepository.deleteById(id);
    }

    @Override
    public Collection<SubCategory> getSubCategories() {
        return subCategoryRepository.findAll();
    }

    @Override
    public SubCategory getSubCategory(Long id) {
        if(subCategoryRepository.findById(id) == null){
            return null;
        }else{
            return subCategoryRepository.findById(id).get();
        }
    }

    public SubCategory getCategoryByName(String name) {
        if(subCategoryRepository.findByName(name) == null){
           return null;
        }else{
            return subCategoryRepository.findByName(name);
        }
    }
    
}
