package com.virtualstore.virtualstore.webServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtualstore.virtualstore.entities.Category;
import com.virtualstore.virtualstore.services.CategoryService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("${url.category}")
public class CategoryServiceController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<Object> getCategories() {
      return new ResponseEntity<>(categoryService.getCategories(), HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Object> getCategory(@PathVariable("id") Long id) {

     try{   
         Category foundCategory = categoryService.getCategory(id);
         return new ResponseEntity<>(foundCategory, HttpStatus.OK);

     }catch(Exception e){
         return new ResponseEntity<>("Category not found", HttpStatus.NOT_FOUND);
     }
    }

    @PostMapping
    public ResponseEntity<Object> createCategory(@RequestBody Category category) {
     categoryService.createCategory(category);
     try{
         if(categoryService.getCategory(category.getId()) == null){
         categoryService.createCategory(category);
         return new ResponseEntity<>("Category is created successfully", HttpStatus.CREATED);
         }else{
             throw new Exception("Category already exists");
         }
         
     }catch(Exception e){
         return new ResponseEntity<>("Category already exists", HttpStatus.CONFLICT);
     }
       
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Object> updateCategory(@PathVariable("id") Long id, @RequestBody Category category) {
     try{
         Category foundCategory = categoryService.getCategory(id);
         if(foundCategory != null){
             categoryService.updateCategory(id,category);
             return new ResponseEntity<>("Category is updated successfully", HttpStatus.OK);
         }else{
             throw new Exception("Category not found");
         }
         
     }catch(Exception e){
         return new ResponseEntity<>("Category not found", HttpStatus.NOT_FOUND);
     }
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
     try{
         if(categoryService.getCategory(id) == null){
             throw new Exception("Category not found");
         }else{
             categoryService.deleteCategory(id);
             return new ResponseEntity<>("Category is deleted successfully", HttpStatus.OK);
         }
     }catch(Exception e){
         return new ResponseEntity<>("Category not found", HttpStatus.NOT_FOUND);
     }
    }
    
}
