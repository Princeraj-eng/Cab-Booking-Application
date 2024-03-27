package com.demo.cabbookingapplication.serviceImpl;

import com.demo.cabbookingapplication.entity.User;
import com.demo.cabbookingapplication.exception.UserException;
import com.demo.cabbookingapplication.repository.USerReository;
import com.demo.cabbookingapplication.service.UserIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserServiceImpl implements UserIService {

    @Autowired
    private USerReository uSerReository;


    @Override
    public User insertUser(User user) throws UserException {
        Optional<User> findUser = uSerReository.findByEmail(user.getEmail());
        if(findUser.isPresent()) {
            throw new UserException("User is already registered");
        }
        else {
            if(user.getUserRole().equalsIgnoreCase("User")) {
                return uSerReository.save(user);
            }
            else {
                throw new UserException("User is already registered");
            }
        }
    }
}
