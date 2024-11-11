package com.virtualstore.virtualstore.webServices;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtualstore.virtualstore.dtos.BillBasicInfo;
import com.virtualstore.virtualstore.dtos.ProductBasicInfo;
import com.virtualstore.virtualstore.entities.Bill;
import com.virtualstore.virtualstore.mappers.BillMapper;
import com.virtualstore.virtualstore.responses.GenericResponse;
import com.virtualstore.virtualstore.services.BillService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = "http://127.0.0.1:5173")
@RestController
@RequestMapping("${url.bill}")
public class BillServiceController {

    @Autowired
    private BillService billService;

    @Autowired
    BillMapper billMapper;

    @GetMapping
    public ResponseEntity<Object> getBills() {

        Collection<BillBasicInfo> bills = billMapper.billstoBillBasicInfos(billService.getBills());
        return new ResponseEntity<>(bills, HttpStatus.OK);
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
    public ResponseEntity<GenericResponse> createBill(@RequestBody Bill bill) {
     GenericResponse response;
     try{
         //if(billService.getBill(bill.getId()) == null){
         billService.createBill(bill);
         response = new GenericResponse().setToken(null).setExpiresIn(0).setError(false).setData(billMapper.billtoBillBasicInfo(bill)).setMsg("Proceso de compra exitoso");
         return ResponseEntity.ok(response);
        // }else{
            //throw new Exception("Bill already exists");
         //}
         
     }catch(Exception e){
        response = new GenericResponse().setToken(null).setExpiresIn(0).setError(true).setData(null).setMsg("Error en el proceso de compra");
         return ResponseEntity.badRequest().body(response);
     }
       
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<GenericResponse> updateBill(@PathVariable("id") Long id, @RequestBody Bill bill) {
        
        GenericResponse response;
        try{
            billService.updateBill(id, bill);
            response = new GenericResponse().setToken(null).setExpiresIn(0).setError(false).setData(billMapper.billtoBillBasicInfo(bill)).setMsg("Bill is updated successfully");
            return ResponseEntity.ok(response);
        }catch(Exception e){
            response = new GenericResponse().setToken(null).setExpiresIn(0).setError(true).setData(null).setMsg(e.getMessage());
            return ResponseEntity.badRequest().body(response);
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
