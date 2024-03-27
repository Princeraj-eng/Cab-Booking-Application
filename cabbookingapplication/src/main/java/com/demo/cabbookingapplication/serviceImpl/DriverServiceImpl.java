package com.demo.cabbookingapplication.serviceImpl;

import com.demo.cabbookingapplication.entity.Driver;
import com.demo.cabbookingapplication.exception.DriverException;
import com.demo.cabbookingapplication.repository.DriverRepository;
import com.demo.cabbookingapplication.service.DriverIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class DriverServiceImpl implements DriverIService {

    @Autowired
    DriverRepository driverRepository;


    @Override
    public Driver insertDriver(Driver driver) throws DriverException {
        Optional<Driver> findDriver = driverRepository.findByLicenceNo(driver.getLicenceNo());
        if(findDriver.isPresent()) {
            throw new DriverException("Driver is already registered");
        }
        else {
            if(driver.getUserRole().equalsIgnoreCase("Driver")) {
                return driverRepository.save(driver);
            }
            else {
                throw new DriverException("User is not a Driver");
            }
        }
    }
}
