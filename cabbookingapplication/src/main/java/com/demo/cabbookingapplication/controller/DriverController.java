package com.demo.cabbookingapplication.controller;

import com.demo.cabbookingapplication.entity.Driver;
import com.demo.cabbookingapplication.exception.DriverException;
import com.demo.cabbookingapplication.service.DriverIService;
import com.demo.cabbookingapplication.serviceImpl.DriverServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/driver")
public class DriverController {

    @Autowired
    private DriverIService driverService;

    @PostMapping("/registerDriver")
    public ResponseEntity<Driver> register(@RequestBody Driver driver) throws DriverException {
        return new ResponseEntity<Driver>(driverService.insertDriver(driver), HttpStatus.CREATED);
    }

    @PostMapping("/onboard/{isTrue}")
    public String onboardDriver(@PathVariable boolean isTrue,@RequestParam("DriverId") Integer driverId)throws DriverException{
        return driverService.onboardDriver(isTrue,driverId);
    }
}
