package com.example.parking.controllers;

import com.example.parking.common.model.User;
import com.example.parking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("v0")
public class UserController {

    @Autowired
    final UserService service = null;

    @RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getUser(final @PathVariable String userId) {

        try {

            User user =  service.getUser(userId);
            return ResponseEntity.status(HttpStatus.OK)
                                 .body(user);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                 .body(null);
        }
    }

    @RequestMapping(value = "/users/", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity createUser(final @RequestBody User user) {
        try {

            System.out.println("User:" + user);
            User userCreated =  service.createUser(user);
            return ResponseEntity.status(HttpStatus.OK)
                                 .body(userCreated);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                 .body(null);
        }
    }
}