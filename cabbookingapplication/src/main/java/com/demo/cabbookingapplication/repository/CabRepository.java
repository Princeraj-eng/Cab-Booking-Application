package com.demo.cabbookingapplication.repository;

import com.demo.cabbookingapplication.entity.Cab;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CabRepository extends JpaRepository<Cab, Integer> {

    Optional<Cab> findByCarNumber(String carNumber);

}
