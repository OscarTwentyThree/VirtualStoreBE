package com.virtualstore.virtualstore.webServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtualstore.virtualstore.entities.Product;
import com.virtualstore.virtualstore.services.ProductService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("${url.product}")
public class ProductServiceController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<Object> getProducts() {
      return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Object> getProduct(@PathVariable("id") Long id) {

     try{   
         Product foundProduct = productService.getProduct(id);
         return new ResponseEntity<>(foundProduct, HttpStatus.OK);

     }catch(Exception e){
         return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
     }
    }

    @PostMapping
    public ResponseEntity<Object> createProduct(@RequestBody Product product) {
     productService.createProduct(product);
     try{
         if(productService.getProduct(product.getId()) == null){
         productService.createProduct(product);
         return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
         }else{
             throw new Exception("Product already exists");
         }
         
     }catch(Exception e){
         return new ResponseEntity<>("Product already exists", HttpStatus.CONFLICT);
     }
       
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        try{
            productService.updateProduct(id, product);
            return new ResponseEntity<>("Product is updated successfully", HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
        try{
            productService.deleteProduct(id);
            return new ResponseEntity<>("Product is deleted successfully", HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
        }
    }


    
}
