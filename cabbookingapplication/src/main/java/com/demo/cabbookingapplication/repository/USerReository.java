package com.demo.cabbookingapplication.repository;

import com.demo.cabbookingapplication.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface USerReository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}
