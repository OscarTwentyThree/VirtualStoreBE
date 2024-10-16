package com.virtualstore.virtualstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtualstore.virtualstore.entities.Status;

public interface StatusRepository extends JpaRepository<Status, Long> {

    
}