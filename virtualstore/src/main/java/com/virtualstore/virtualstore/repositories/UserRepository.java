package com.virtualstore.virtualstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;
import java.util.Optional;
import com.virtualstore.virtualstore.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public Optional<User>findByEmail(@Param("email") String email);
}
