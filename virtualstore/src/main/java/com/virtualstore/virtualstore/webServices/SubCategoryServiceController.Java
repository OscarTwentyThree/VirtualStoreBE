package com.virtualstore.virtualstore.webServices;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtualstore.virtualstore.dtos.SubCategoryBasicInfo;
import com.virtualstore.virtualstore.entities.SubCategory;
import com.virtualstore.virtualstore.mappers.SubCategoryMapper;
import com.virtualstore.virtualstore.services.SubCategoryService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = "http://127.0.0.1:5173")
@RestController
@RequestMapping("${url.subcategory}")
public class SubCategoryServiceController {

    @Autowired
    private SubCategoryService subCategoryService;

    @Autowired
    SubCategoryMapper subCategoryMapper;

    @GetMapping
    public ResponseEntity<Object> getSubCategories() {

        Collection<SubCategoryBasicInfo> subCategories = subCategoryMapper.subCategoriesToSubCategoryBasicInfos(subCategoryService.getSubCategories());
        return new ResponseEntity<>(subCategories, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Object> getSubCategories(@PathVariable("id") Long id) {

        try {
            SubCategory foundSubCategory = subCategoryService.getSubCategory(id);
            return new ResponseEntity<>(subCategoryMapper.subCategoryToSubCategoryBasicInfo(foundSubCategory), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>("SubCategory not found", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Object> createProduct(@RequestBody SubCategory subCategory) {
        try {
            if (subCategoryService.getCategoryByName(subCategory.getName()) != null) {
                return new ResponseEntity<>("SubCategory already exist", HttpStatus.CREATED);
            } else {
                subCategoryService.createSubCategory(subCategory);
                return new ResponseEntity<>("SubCategory is created successfully", HttpStatus.CREATED);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }

    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable("id") Long id, @RequestBody SubCategory subCategory) {

        subCategoryService.updateSubCategory(id, subCategory);
        return new ResponseEntity<>("SubCategory is updated successsfully", HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
        try {
            if (subCategoryService.getSubCategory(id) == null) {
                throw new Exception("SubCategory not found");
            } else {
                subCategoryService.deleteSubCategory(id);
                return new ResponseEntity<>("SubCategory is deleted successsfully", HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("SubCategory not found", HttpStatus.NOT_FOUND);
        }
    }
}