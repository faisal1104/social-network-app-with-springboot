package com.example.springbootform.repository;
import com.example.springbootform.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {

    Role findByAuthority(String authority);

    boolean existsByAuthority(String s);
}
