package com.demo.cabbookingapplication.repository;

import com.demo.cabbookingapplication.entity.TripBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripBookingRepository extends JpaRepository<TripBooking, Integer> {
}
