package com.demo.cabbookingapplication.repository;

import com.demo.cabbookingapplication.entity.Driver;
import com.demo.cabbookingapplication.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface DriverRepository extends JpaRepository<Driver,Integer> {
    Optional<Driver> findByLicenceNo(String licenceNo);
    Optional<Driver> findByEmail(String email);
}
