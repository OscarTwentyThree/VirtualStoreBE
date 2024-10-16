package com.virtualstore.virtualstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import com.virtualstore.virtualstore.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public User findByEmail(@Param("email") String email);
}
