package com.virtualstore.virtualstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtualstore.virtualstore.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

    
}
