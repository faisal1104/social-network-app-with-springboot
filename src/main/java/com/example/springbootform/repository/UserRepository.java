package com.example.springbootform.repository;
import com.example.springbootform.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<UserDetails> findByUsername(String username);

    boolean existsByUsername(String s);

    boolean existsByEmail(String s);
}
