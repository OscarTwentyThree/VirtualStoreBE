package com.virtualstore.virtualstore.webServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtualstore.virtualstore.entities.Order;
import com.virtualstore.virtualstore.services.OrderService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("${url.order}")
public class OrderServiceController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<Object> getOrders() {
      return new ResponseEntity<>(orderService.getOrders(), HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Object> getOrder(@PathVariable("id") Long id) {

     try{   
         Order foundOrder = orderService.getOrder(id);
         return new ResponseEntity<>(foundOrder, HttpStatus.OK);

     }catch(Exception e){
         return new ResponseEntity<>("Order not found", HttpStatus.NOT_FOUND);
     }
    }

    @PostMapping
    public ResponseEntity<Object> createOrder(@RequestBody Order order) {
     orderService.createOrder(order);
     try{
         if(orderService.getOrder(order.getId()) == null){
         orderService.createOrder(order);
         return new ResponseEntity<>("Order is created successfully", HttpStatus.CREATED);
         }else{
             throw new Exception("Order already exists");
         }
         
     }catch(Exception e){
         return new ResponseEntity<>("Order already exists", HttpStatus.CONFLICT);
     }
       
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Object> updateOrder(@PathVariable("id") Long id, @RequestBody Order order) {
        try{
            orderService.updateOrder(id, order);
            return new ResponseEntity<>("Order is updated successfully", HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>("Order not found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
        try{
            Order foundOrder = orderService.getOrder(id);
            if(foundOrder != null){
                orderService.deleteOrder(id);
                return new ResponseEntity<>("Order is deleted successfully", HttpStatus.OK);
            }else{
                throw new Exception("Order not found");
            }
        }catch(Exception e){
            return new ResponseEntity<>("Order not found", HttpStatus.NOT_FOUND);
        }
    }

    
}
