package com.virtualstore.virtualstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.virtualstore.virtualstore.entities.Status;

import java.util.Optional;

public interface StatusRepository extends JpaRepository<Status, Long> {

    public Status findByName(@Param("name") String name);

    
}