package com.demo.cabbookingapplication.service;

import com.demo.cabbookingapplication.entity.User;
import com.demo.cabbookingapplication.exception.UserException;

public interface UserIService {

    User insertUser(User user)throws UserException;
}
