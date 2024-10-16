package com.virtualstore.virtualstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtualstore.virtualstore.entities.ShippingAddress;

public interface ShippingAddressRepository extends JpaRepository<ShippingAddress, Long> {

    
} 
