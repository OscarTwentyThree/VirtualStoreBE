package com.virtualstore.virtualstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.virtualstore.virtualstore.entities.SubCategory;

public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {

    public SubCategory findByName(@Param("name") String name);
}