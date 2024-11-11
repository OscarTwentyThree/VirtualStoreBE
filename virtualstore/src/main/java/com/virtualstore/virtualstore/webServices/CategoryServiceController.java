package com.virtualstore.virtualstore.webServices;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtualstore.virtualstore.dtos.CategoryBasicInfo;
import com.virtualstore.virtualstore.entities.Category;
import com.virtualstore.virtualstore.mappers.CategoryMapper;
import com.virtualstore.virtualstore.services.CategoryService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = "http://127.0.0.1:5173")
@RestController
@RequestMapping("${url.category}")
public class CategoryServiceController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryMapper categoryMapper;

    @GetMapping
    public ResponseEntity<Object> getCategories() {

        Collection<CategoryBasicInfo> categories = categoryMapper.categoriesToCategoryBasicInfos(categoryService.getCategories());
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Object> getCategory(@PathVariable("id") Long id) {

        try {
            Category foundCategory = categoryService.getCategory(id);
            return new ResponseEntity<>(categoryMapper.categoryToCategoryBasicInfo(foundCategory), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>("Category not found", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Object> createCategory(@RequestBody Category category) {
        try {
            if (categoryService.getCategoryByName(category.getName()) != null) {
                return new ResponseEntity<>("Category already exist", HttpStatus.CREATED);
            } else {
                categoryService.createCategory(category);
                return new ResponseEntity<>("Category is created successfully", HttpStatus.CREATED);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }

    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Object> updateCategory(@PathVariable("id") Long id, @RequestBody Category category) {
        try {
            Category foundCategory = categoryService.getCategory(id);
            if (foundCategory != null) {
                categoryService.updateCategory(id, category);
                return new ResponseEntity<>("Category is updated successfully", HttpStatus.OK);
            } else {
                throw new Exception("Category not found");
            }

        } catch (Exception e) {
            return new ResponseEntity<>("Category not found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
        try {
            if (categoryService.getCategory(id) == null) {
                throw new Exception("Category not found");
            } else {
                categoryService.deleteCategory(id);
                return new ResponseEntity<>("Category is deleted successfully", HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Category not found", HttpStatus.NOT_FOUND);
        }
    }

}
