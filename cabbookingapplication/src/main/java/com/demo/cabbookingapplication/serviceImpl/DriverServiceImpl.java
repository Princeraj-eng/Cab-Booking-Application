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

    @Override
    public String onboardDriver(boolean isTrue, Integer driverId) throws DriverException{

        Optional<Driver> findDriverOpt = driverRepository.findById(driverId);

        // First, check if the driver was found
        if (!findDriverOpt.isPresent()) {
            throw new DriverException("Driver not found with ID: " + driverId);
        }

        Driver findDriver = findDriverOpt.get();
        String responseMessage;

        // Check if the current state matches the intended state
        if (findDriver.isOnboard() == isTrue) {
            throw new DriverException("Driver is already " + (isTrue ? "onboard" : "deboarded"));
        }

        // Update the onboard status
        findDriver.setOnboard(isTrue);

        // Set the appropriate response message
        responseMessage = "Driver is now " + (isTrue ? "onboarded" : "deboarded");

        // Optionally, save the updated driver object if changes need to be persistent
        driverRepository.save(findDriver);

        return responseMessage;
    }
}
