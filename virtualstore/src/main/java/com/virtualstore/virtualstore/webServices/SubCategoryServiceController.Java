
package com.virtualstore.virtualstore.webServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtualstore.virtualstore.entities.SubCategory;
import com.virtualstore.virtualstore.services.SubCategoryService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("${url.subCategory}")
public class SubCategoryServiceController {
    
    @Autowired
    private SubCategoryService subCategoryService;

    @GetMapping
    public ResponseEntity<Object> getSubCategories() {
      return new ResponseEntity<>(subCategoryService.getSubCategories(), HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
   public ResponseEntity<Object> getSubCategories(@PathVariable("id") Long id) {

    try{   
        SubCategory foundSubCategory = subCategoryService.getSubCategory(id);
        return new ResponseEntity<>(foundSubCategory, HttpStatus.OK);

    }catch(Exception e){
        return new ResponseEntity<>("SubCategory not found", HttpStatus.NOT_FOUND);
    }
  }
   
   @PostMapping
   public ResponseEntity<Object> createProduct(@RequestBody SubCategory subCategory) {
    SubCategoryService.createSubCategory(subCategory);
    try{
        if(subCategoryService.getSubCategory(subCategory.getId()) == null){
        subCategoryService.createSubCategory(subCategory);
        return new ResponseEntity<>("SubCategory is created successfully", HttpStatus.CREATED);
        }else{
            throw new Exception("SubCategory already exists");
        }
        
    }catch(Exception e){
        return new ResponseEntity<>("SubCategory already exists", HttpStatus.CONFLICT);
    }
      
   }

   @PutMapping(value = "{id}")
   public ResponseEntity<Object> 
      updateProduct(@PathVariable("id") Long id, @RequestBody SubCategory subCategory) {
      
      SubCategoryService.updateSubCategory(id, subCategory);
      return new ResponseEntity<>("SubCategory is updated successsfully", HttpStatus.OK);
   }

   @DeleteMapping(value = "{id}")
   public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
    try{
        if(subCategoryService.getSubCategory(id) == null){
            throw new Exception("SubCategory not found");
        }else{
            subCategoryService.deleteSubCategory(id);
            return new ResponseEntity<>("SubCategory is deleted successsfully", HttpStatus.OK);
        }
    }catch(Exception e){
        return new ResponseEntity<>("SubCategory not found", HttpStatus.NOT_FOUND);
    }
   } 
}
