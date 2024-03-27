package com.demo.cabbookingapplication.repository;

import com.demo.cabbookingapplication.entity.CurrentUserSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CurrentUserSessionRepository extends JpaRepository<CurrentUserSession, Integer> {

    Optional<CurrentUserSession> findByUserId(Integer userId);
}
