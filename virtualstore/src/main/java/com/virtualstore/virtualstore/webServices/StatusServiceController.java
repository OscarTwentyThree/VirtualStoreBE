package com.virtualstore.virtualstore.webServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtualstore.virtualstore.entities.Status;
import com.virtualstore.virtualstore.mappers.StatusMapper;
import com.virtualstore.virtualstore.services.StatusService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = "http://127.0.0.1:5173")
@RestController
@RequestMapping("${url.status}")
public class StatusServiceController {

    @Autowired
    private StatusService statusService;

    @Autowired
    StatusMapper statusMapper;

    @GetMapping
    public ResponseEntity<Object> getStatuses() {
      return new ResponseEntity<>(statusMapper.statusToStatusBasicInfos(statusService.getStates()), HttpStatus.OK);
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
        /*Validate is the status exist bafore create a new one into try catch*/
        try{
            if(statusService.getStatusByName(status.getName()) != null){
                return new ResponseEntity<>("Status already exist", HttpStatus.CONFLICT);
            }else{
                statusService.createStatus(status);
                return new ResponseEntity<>("Status is created successfully", HttpStatus.CREATED);
            }
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
        


    }
   
    
    @PutMapping(value = "{id}")
    public ResponseEntity<Object> updateStatus(@PathVariable("id") Long id, @RequestBody Status status) {

        /*productService.updateProduct(id, product);
            response = new GenericResponse().setToken(null).setExpiresIn(0).setError(false).setData(productMapper.productToProductBasicInfo(product)).setMsg("Producto actualizado");
            return ResponseEntity.ok(response); */
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
