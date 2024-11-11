package com.virtualstore.virtualstore.webServices;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtualstore.virtualstore.dtos.BillBasicInfo;
import com.virtualstore.virtualstore.dtos.OrderBasicInfo;
import com.virtualstore.virtualstore.entities.Order;
import com.virtualstore.virtualstore.mappers.OrderMapper;
import com.virtualstore.virtualstore.responses.GenericResponse;
import com.virtualstore.virtualstore.services.OrderService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = "http://127.0.0.1:5173")
@RestController
@RequestMapping("${url.order}")
public class OrderServiceController {

    @Autowired
    private OrderService orderService;

    @Autowired
    OrderMapper orderMapper;

    @GetMapping
    public ResponseEntity<Object> getOrders() {

        Collection<OrderBasicInfo> orders = orderMapper.ordersToOrderBasicInfos(orderService.getOrders());
        return new ResponseEntity<>(orders, HttpStatus.OK);
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
    public ResponseEntity<GenericResponse> createOrder(@RequestBody Order order) {
     GenericResponse response;
     try{
         //if(orderService.getOrder(order.getId()) == null){
         orderService.createOrder(order);
         response = new GenericResponse().setToken(null).setExpiresIn(0).setError(false).setData(orderMapper.orderToOrderBasicInfo(order)).setMsg("Orden agregada");
         return ResponseEntity.ok(response);
         //}else{
           //  throw new Exception("Order already exists");
        // }
         
     }catch(Exception e){
         response = new GenericResponse().setToken(null).setExpiresIn(0).setError(true).setData(null).setMsg("Error al agregar la orden");
         return ResponseEntity.badRequest().body(response);
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
