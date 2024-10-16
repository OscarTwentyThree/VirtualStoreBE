package com.virtualstore.virtualstore.webServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtualstore.virtualstore.entities.ShippingAddress;
import com.virtualstore.virtualstore.services.ShippingAddressService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("${url.shipping_address}")
public class ShippingAddressServiceController {

    @Autowired
    private ShippingAddressService shippingAddressService;

    @GetMapping
    public ResponseEntity<Object> getShippingAddresses() {
      return new ResponseEntity<>(shippingAddressService.getShippingAddresses(), HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Object> getShippingAddress(@PathVariable("id") Long id) {

     try{   
         ShippingAddress foundShippingAddress = shippingAddressService.getShippingAddress(id);
         return new ResponseEntity<>(foundShippingAddress, HttpStatus.OK);

     }catch(Exception e){
         return new ResponseEntity<>("ShippingAddress not found", HttpStatus.NOT_FOUND);
     }
    }

    @PostMapping
    public ResponseEntity<Object> createShippingAddress(@RequestBody ShippingAddress shippingAddress) {
     shippingAddressService.createShippingAddress(shippingAddress);
     try{
         if(shippingAddressService.getShippingAddress(shippingAddress.getId()) == null){
         shippingAddressService.createShippingAddress(shippingAddress);
         return new ResponseEntity<>("ShippingAddress is created successfully", HttpStatus.CREATED);
         }else{
             throw new Exception("ShippingAddress already exists");
         }
         
     }catch(Exception e){
         return new ResponseEntity<>("ShippingAddress already exists", HttpStatus.CONFLICT);
     }
       
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Object> updateShippingAddress(@PathVariable("id") Long id, @RequestBody ShippingAddress shippingAddress) {
        try{
            shippingAddressService.updateShippingAddress(id, shippingAddress);
            return new ResponseEntity<>("ShippingAddress is updated successfully", HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>("ShippingAddress not found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Object> deleteShippingAddress(@PathVariable("id") Long id) {
        try{
            shippingAddressService.deleteShippingAddress(id);
            return new ResponseEntity<>("ShippingAddress is deleted successfully", HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>("ShippingAddress not found", HttpStatus.NOT_FOUND);
        }
    }
    
}
