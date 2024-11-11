package com.virtualstore.virtualstore.webServices;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtualstore.virtualstore.dtos.ShippingAddressBasicInfo;
import com.virtualstore.virtualstore.entities.ShippingAddress;
import com.virtualstore.virtualstore.mappers.ShippingAddressMapper;
import com.virtualstore.virtualstore.responses.GenericResponse;
import com.virtualstore.virtualstore.services.ShippingAddressService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = "http://127.0.0.1:5173")
@RestController
@RequestMapping("${url.shipping_address}")
public class ShippingAddressServiceController {

    @Autowired
    private ShippingAddressService shippingAddressService;

    @Autowired
    ShippingAddressMapper shippingAddressMapper;

    @GetMapping
    public ResponseEntity<Object> getShippingAddresses() {


        Collection<ShippingAddressBasicInfo> shippingAddresses = shippingAddressMapper.shippingAddressesToShippingAddressBasicInfos(shippingAddressService.getShippingAddresses());
        return ResponseEntity.ok(shippingAddresses);
     
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
    public ResponseEntity<GenericResponse> createShippingAddress(@RequestBody ShippingAddress shippingAddress) {
    GenericResponse response;
     try{
         //if(shippingAddressService.getShippingAddress(shippingAddress.getId()) == null){
         shippingAddressService.createShippingAddress(shippingAddress);
         response = new GenericResponse().setToken(null).setExpiresIn(0).setError(false).setData(shippingAddressMapper.shippingAddressToShippingAddressBasicInfo(shippingAddress)).setMsg("Producto agregado");
         return ResponseEntity.ok(response);
        // }else{
          //   throw new Exception("ShippingAddress already exists");
       //  }
         
     }catch(Exception e){
         response = new GenericResponse().setToken(null).setExpiresIn(0).setError(true).setData(null).setMsg("Error al agregar el producto");
         return ResponseEntity.badRequest().body(response);
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
