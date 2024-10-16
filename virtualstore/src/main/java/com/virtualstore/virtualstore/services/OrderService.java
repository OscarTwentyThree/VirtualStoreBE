package com.virtualstore.virtualstore.services;
import java.util.Collection;

import com.virtualstore.virtualstore.entities.Order;

public interface OrderService {
    
    public abstract void createOrder(Order order);
    public abstract void updateOrder(Long id, Order order);
    public abstract void deleteOrder(Long id);
    public abstract Collection<Order> getOrders();
    public abstract Order getOrder(Long id);
}
