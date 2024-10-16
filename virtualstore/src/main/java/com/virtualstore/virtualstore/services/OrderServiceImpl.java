package com.virtualstore.virtualstore.services;

import java.util.Collection;
import com.virtualstore.virtualstore.entities.Order;
import com.virtualstore.virtualstore.repositories.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void createOrder(Order order) {
        orderRepository.save(order);
    }

    @Override
    public void updateOrder(Long id, Order order) {
        Order orderToUpdate = orderRepository.findById(id).get();
        orderToUpdate.setAmount(order.getAmount());
        orderToUpdate.setQuantity(order.getQuantity());
        orderToUpdate.setProduct(order.getProduct());
        orderToUpdate.setBill(order.getBill());
        orderRepository.save(orderToUpdate);
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public Collection<Order> getOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrder(Long id) {
        if(orderRepository.findById(id) == null){
            throw new RuntimeException("Order not found");
        }else{
            return orderRepository.findById(id).get();
        }
    }
    
}
