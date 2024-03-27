package com.demo.cabbookingapplication.service;


import com.demo.cabbookingapplication.entity.RideDTO;
import com.demo.cabbookingapplication.entity.TripBooking;
import com.demo.cabbookingapplication.exception.CabException;
import com.demo.cabbookingapplication.exception.CurrentUserSessionException;
import com.demo.cabbookingapplication.exception.TripBookingException;
import java.util.List;

public interface TripBookingIService {

    List<RideDTO> searchByLocation(String sourceLocation, String destinationLocation, Integer userid)throws TripBookingException, CurrentUserSessionException;

    TripBooking BookRequest(TripBooking tripBooking,Integer cabId,Integer userId, String driverName) throws  CabException,CurrentUserSessionException;

}
