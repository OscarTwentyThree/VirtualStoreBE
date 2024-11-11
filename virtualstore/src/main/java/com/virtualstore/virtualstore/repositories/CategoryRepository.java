package com.virtualstore.virtualstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.virtualstore.virtualstore.entities.Category;


public interface CategoryRepository extends JpaRepository<Category, Long> {

    public Category findByName(@Param("name") String name);
} 