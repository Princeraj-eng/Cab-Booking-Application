package com.demo.cabbookingapplication.serviceImpl;

import com.demo.cabbookingapplication.entity.*;
import com.demo.cabbookingapplication.exception.CabException;
import com.demo.cabbookingapplication.exception.CurrentUserSessionException;
import com.demo.cabbookingapplication.exception.TripBookingException;
import com.demo.cabbookingapplication.repository.CabRepository;
import com.demo.cabbookingapplication.repository.CurrentUserSessionRepository;
import com.demo.cabbookingapplication.repository.TripBookingRepository;
import com.demo.cabbookingapplication.repository.USerReository;
import com.demo.cabbookingapplication.service.TripBookingIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TripBookingServiceImpl implements TripBookingIService {

    @Autowired
    private TripBookingRepository tripBookingRepository;
    @Autowired
    CurrentUserSessionRepository currentUserSessionRepository;
    @Autowired
    CabRepository cabRepository;

    @Autowired
    private USerReository uSerReository;

    @Override
    public List<RideDTO> searchByLocation(String sourceLocation, String destinationLocation, Integer userid) throws TripBookingException, CurrentUserSessionException {
        Optional<CurrentUserSession> validUser = currentUserSessionRepository.findByUserId(userid);
        if(validUser.isPresent()) {
            List<Cab> allCab = new ArrayList<>();
                    cabRepository.findAll().forEach(allCab::add);
            List<RideDTO> availableCab = new ArrayList<>();
            for(Cab cab : allCab) {
                if(cab.getCabCurrStatus().equalsIgnoreCase("Available") && cab.getSourceLocation().equalsIgnoreCase(sourceLocation)&& cab.getDestinationLocation().equalsIgnoreCase(destinationLocation)) {
                    RideDTO r = new RideDTO();
                    r.setCabId(cab.getCabId());
                    r.setCarType(cab.getCarType());
                    r.setCarName(cab.getCarName());
                    r.setCarNumber(cab.getCarNumber());
                    r.setSourceLocation(cab.getSourceLocation());
                    r.setDestinationLocation(cab.getDestinationLocation());
                    r.setDriverId(cab.getDriver().getDriverId());
                    r.setLicenceNo(cab.getDriver().getLicenceNo());
                    r.setRating(cab.getDriver().getRating());
                    r.setCurrLocation(cab.getDriver().getCurrLocation());
                    r.setCurrDriverStatus(cab.getDriver().getCurrDriverStatus());
                    r.setDriverName(cab.getDriver().getDriverName());
                    availableCab.add(r);
                }
            }
            if(availableCab.isEmpty()) {
                throw new TripBookingException("No Cab Available in this Location");
            }
            else {
                return availableCab;
            }
        }
        else {
            throw new CurrentUserSessionException("User Not Login");
        }
    }

    @Override
    public TripBooking BookRequest(TripBooking tripBooking,Integer cabId,Integer userId, String driverName) throws  CabException, CurrentUserSessionException {
        Optional<CurrentUserSession> validUser = currentUserSessionRepository.findByUserId(userId);
        if(validUser.isPresent()) {
         //   CurrentUserSession currUser = validUser.get();
            Optional<User> cuser = uSerReository.findById(userId);
            User user = cuser.get();
            List<TripBooking> allTripByCustomer = user.getTripBooking();
                Optional<Cab> addCab = cabRepository.findById(cabId);
                if(addCab.isPresent()) {
                    Cab newCab = addCab.get();
                    if(newCab.getCabCurrStatus().equalsIgnoreCase("Available")) {
                        newCab.setCabCurrStatus("Pending");
                        tripBooking.setCab(newCab);
                        tripBooking.setUser(user);
                        tripBooking.setCurrStatus("Pending");
                        allTripByCustomer.add(tripBooking);
                        uSerReository.save(user);
                        return tripBookingRepository.save(tripBooking);

                    }
                    else {
                        throw new CabException("This Cab is not available currently for location or avability purpose");
                    }
                }
                else {
                    throw new CabException("No Cab Present with the given Credentials");
                }
        }
        else {
            throw new CurrentUserSessionException("User is Not Login");
        }
    }
}
