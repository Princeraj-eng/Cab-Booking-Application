package com.demo.cabbookingapplication.controller;

import com.demo.cabbookingapplication.entity.User;
import com.demo.cabbookingapplication.exception.UserException;
import com.demo.cabbookingapplication.service.UserIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserIService userService;

    @PostMapping("/registerUser")
    public ResponseEntity<User> register(@RequestBody User user) throws UserException {
        return new ResponseEntity<User>(userService.insertUser(user), HttpStatus.CREATED);
    }
}
