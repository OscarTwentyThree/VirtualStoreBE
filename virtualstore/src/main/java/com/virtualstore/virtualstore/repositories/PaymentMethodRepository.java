package com.virtualstore.virtualstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtualstore.virtualstore.entities.PaymentMethod;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {

    
} 
