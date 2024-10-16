package com.virtualstore.virtualstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtualstore.virtualstore.entities.Bill;

public interface BillRepository extends JpaRepository<Bill, Long> {
    
}

  