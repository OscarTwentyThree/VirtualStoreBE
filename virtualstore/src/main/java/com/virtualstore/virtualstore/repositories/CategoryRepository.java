package com.virtualstore.virtualstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.virtualstore.virtualstore.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    
} 