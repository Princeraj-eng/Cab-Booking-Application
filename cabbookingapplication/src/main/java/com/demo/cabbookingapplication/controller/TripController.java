package com.demo.cabbookingapplication.controller;


import com.demo.cabbookingapplication.entity.RideDTO;
import com.demo.cabbookingapplication.entity.TripBooking;
import com.demo.cabbookingapplication.exception.CabException;
import com.demo.cabbookingapplication.exception.CurrentUserSessionException;
import com.demo.cabbookingapplication.exception.TripBookingException;
import com.demo.cabbookingapplication.service.TripBookingIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tripBooking")
public class TripController {

    @Autowired
    private TripBookingIService tripBookingIService;

    @GetMapping("/searchCab")
    public ResponseEntity<List<RideDTO>> findRideBySourceAndDestinationLocation(
            @RequestParam("sourceLocation") String sourceLocation, @RequestParam("destinationLocation") String destinationLocation, @RequestParam("userid") Integer userid)
            throws CurrentUserSessionException, TripBookingException {
        return new ResponseEntity<List<RideDTO>>(tripBookingIService.searchByLocation(sourceLocation,destinationLocation, userid), HttpStatus.OK);
    }

    @PostMapping("/BookRequest")
    public ResponseEntity<TripBooking> BookRequest(@RequestBody TripBooking tripBooking,@RequestParam("CabId") Integer cabId,@RequestParam("UserId") Integer userId, @RequestParam("DriverName") String driverName)
            throws  CabException, CurrentUserSessionException{
        return new ResponseEntity<TripBooking>(tripBookingIService.BookRequest(tripBooking,cabId,userId, driverName),HttpStatus.OK);
    }
}
