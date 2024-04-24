package com.demo.cabbookingapplication.service;

import com.demo.cabbookingapplication.entity.Driver;
import com.demo.cabbookingapplication.exception.DriverException;

public interface DriverIService {

    Driver insertDriver(Driver driver)throws DriverException;

    String onboardDriver( boolean isTrue, Integer driverId)throws DriverException;
}
