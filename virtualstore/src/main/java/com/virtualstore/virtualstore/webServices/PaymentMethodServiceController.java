package com.virtualstore.virtualstore.webServices;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtualstore.virtualstore.dtos.PaymentMethodBasicInfo;
import com.virtualstore.virtualstore.entities.PaymentMethod;
import com.virtualstore.virtualstore.mappers.PaymentMethodMapper;
import com.virtualstore.virtualstore.services.PaymentMethodService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = "http://127.0.0.1:5173")
@RestController
@RequestMapping("${url.payment_method}")
public class PaymentMethodServiceController {

    @Autowired
    private PaymentMethodService paymentMethodService;

    @Autowired
    PaymentMethodMapper paymentMethodMapper;

    @GetMapping
    public ResponseEntity<Object> getPaymentMethods() {

        Collection<PaymentMethodBasicInfo> paymentMethods = paymentMethodMapper.paymentMethodsToPaymentMethodBasicInfos(paymentMethodService.getPaymentMethods());
        return new ResponseEntity<>(paymentMethods, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Object> getPaymentMethod(@PathVariable("id") Long id) {

     try{   
         PaymentMethod foundPaymentMethod = paymentMethodService.getPaymentMethod(id);
         return new ResponseEntity<>(foundPaymentMethod, HttpStatus.OK);

     }catch(Exception e){
         return new ResponseEntity<>("PaymentMethod not found", HttpStatus.NOT_FOUND);
     }
    }

    @PostMapping
    public ResponseEntity<Object> createPaymentMethod(@RequestBody PaymentMethod paymentMethod) {
     paymentMethodService.createPaymentMethod(paymentMethod);
     try{
         if(paymentMethodService.getPaymentMethod(paymentMethod.getId()) == null){
         paymentMethodService.createPaymentMethod(paymentMethod);
         return new ResponseEntity<>("PaymentMethod is created successfully", HttpStatus.CREATED);
         }else{
             throw new Exception("PaymentMethod already exists");
         }
         
     }catch(Exception e){
         return new ResponseEntity<>("PaymentMethod already exists", HttpStatus.CONFLICT);
     }
       
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Object> updatePaymentMethod(@PathVariable("id") Long id, @RequestBody PaymentMethod paymentMethod) {
        try{
            paymentMethodService.updatePaymentMethod(id, paymentMethod);
            return new ResponseEntity<>("PaymentMethod is updated successfully", HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>("PaymentMethod not found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
        try{
            paymentMethodService.deletePaymentMethod(id);
            return new ResponseEntity<>("PaymentMethod is deleted successfully", HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>("PaymentMethod not found", HttpStatus.NOT_FOUND);
        }
    }
    
}
