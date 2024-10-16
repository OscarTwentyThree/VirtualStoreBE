package com.virtualstore.virtualstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtualstore.virtualstore.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    
} 
