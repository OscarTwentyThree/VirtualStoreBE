package com.virtualstore.virtualstore.webServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtualstore.virtualstore.entities.Status;
import com.virtualstore.virtualstore.services.StatusService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("${url.status}")
public class StatusServiceController {

    @Autowired
    private StatusService statusService;

    @GetMapping
    public ResponseEntity<Object> getStatuses() {
      return new ResponseEntity<>(statusService.getStates(), HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Object> getStatus(@PathVariable("id") Long id) {

     try{   
         Status foundStatus = statusService.getStatus(id);
         return new ResponseEntity<>(foundStatus, HttpStatus.OK);

     }catch(Exception e){
         return new ResponseEntity<>("Status not found", HttpStatus.NOT_FOUND);
     }
    }

    @PostMapping
    public ResponseEntity<Object> createStatus(@RequestBody Status status) {
     statusService.createStatus(status);
     try{
         if(statusService.getStatus(status.getId()) == null){
         statusService.createStatus(status);
         return new ResponseEntity<>("Status is created successfully", HttpStatus.CREATED);
         }else{
             throw new Exception("Status already exists");
         }
         
     }catch(Exception e){
         return new ResponseEntity<>("Status already exists", HttpStatus.CONFLICT);
     }
       
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Object> updateStatus(@PathVariable("id") Long id, @RequestBody Status status) {
     try{
         statusService.updateStatus(id, status);
         return new ResponseEntity<>("Status is updated successfully", HttpStatus.OK);
     }catch(Exception e){
         return new ResponseEntity<>("Status not found", HttpStatus.NOT_FOUND);
     }
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Object> deleteStatus(@PathVariable("id") Long id) {
     try{
         statusService.deleteStatus(id);
         return new ResponseEntity<>("Status is deleted successfully", HttpStatus.OK);
     }catch(Exception e){
         return new ResponseEntity<>("Status not found", HttpStatus.NOT_FOUND);
     }
    }
    
}
