package com.example.parking.controllers;

import com.example.parking.common.model.RegisterEvent;
import com.example.parking.service.RegisterService;
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
public class RegisterController {

    @Autowired
    RegisterService service;

    @RequestMapping(value = "/parking/{id}/register/", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity register(final @RequestBody RegisterEvent event) {
        try {

            RegisterEvent userCreated =  service.register(event);
            return ResponseEntity.status(HttpStatus.OK)
                                 .body(userCreated);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                 .body(null);
        }
    }

    @RequestMapping(value = "/parking/{id}/deregister/", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity deRegister(final @RequestBody RegisterEvent event) {
        try {

            RegisterEvent userCreated =  service.deRegister(event);
            return ResponseEntity.status(HttpStatus.OK)
                                 .body(userCreated);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                 .body(null);
        }
    }

    @RequestMapping(value = "/parking/{parkingId}/register/{registerId}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getRegister(final @PathVariable String parkingId,
                                      final @PathVariable String registerId) {
        return null;
    }
}