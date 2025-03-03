package com.rih.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rih.backend.model.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}

