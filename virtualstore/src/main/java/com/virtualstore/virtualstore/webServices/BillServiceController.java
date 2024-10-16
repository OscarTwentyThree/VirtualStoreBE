package com.virtualstore.virtualstore.webServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.virtualstore.virtualstore.entities.Bill;
import com.virtualstore.virtualstore.services.BillService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("${url.bill}")
public class BillServiceController {

    @Autowired
    private BillService billService;

    @GetMapping
    public ResponseEntity<Object> getBills() {
      return new ResponseEntity<>(billService.getBills(), HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Object> getBill(@PathVariable("id") Long id) {

     try{   
         Bill foundBill = billService.getBill(id);
         return new ResponseEntity<>(foundBill, HttpStatus.OK);

     }catch(Exception e){
         return new ResponseEntity<>("Bill not found", HttpStatus.NOT_FOUND);
     }
    }

    @PostMapping
    public ResponseEntity<Object> createBill(@RequestBody Bill bill) {
     billService.createBill(bill);
     try{
         if(billService.getBill(bill.getId()) == null){
         billService.createBill(bill);
         return new ResponseEntity<>("Bill is created successfully", HttpStatus.CREATED);
         }else{
             throw new Exception("Bill already exists");
         }
         
     }catch(Exception e){
         return new ResponseEntity<>("Bill already exists", HttpStatus.CONFLICT);
     }
       
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Object> updateBill(@PathVariable("id") Long id, @RequestBody Bill bill) {
     try{
         Bill foundBill = billService.getBill(id);
         if(foundBill != null){
             billService.updateBill(id, bill);
             return new ResponseEntity<>("Bill is updated successfully", HttpStatus.OK);
         }else{
             throw new Exception("Bill not found");
         }
     }catch(Exception e){
         return new ResponseEntity<>("Bill not found", HttpStatus.NOT_FOUND);
     }
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
     try{
         Bill foundBill = billService.getBill(id);
         if(foundBill != null){
             billService.deleteBill(id);
             return new ResponseEntity<>("Bill is deleted successfully", HttpStatus.OK);
         }else{
             throw new Exception("Bill not found");
         }
     }catch(Exception e){
         return new ResponseEntity<>("Bill not found", HttpStatus.NOT_FOUND);
     }
    }
    
}
