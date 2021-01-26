package com.example.springbootform.repository;

import com.example.springbootform.model.Status;
import com.example.springbootform.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StatusRepo extends JpaRepository<Status, Long> {

    @Query(value = "SELECT u from status_table u where u.statusPrivacy='Public'")
    List<Status> findAllPublic();
}
