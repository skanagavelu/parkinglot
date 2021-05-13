package com.example.parking.controllers;

import com.example.parking.common.model.ParkingToken;
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

    @RequestMapping(value = "/parkingStations/{parkingStationsId}/register/", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity register(final @PathVariable String parkingStationsId,
                                   final @RequestBody ParkingToken token) {
        try {

            ParkingToken userCreated =  service.register(token);
            return ResponseEntity.status(HttpStatus.OK)
                                 .body(userCreated);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                 .body(null);
        }
    }

    @RequestMapping(value = "/parkingStations/{parkingStationsId}/deRegister/{parkingTokenId}",
                    method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity deRegister(final @PathVariable String parkingStationsId,
                                     final @RequestBody String parkingTokenId) {
        try {

            ParkingToken userCreated =  service.deRegister(parkingTokenId);
            return ResponseEntity.status(HttpStatus.OK)
                                 .body(userCreated);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                 .body(null);
        }
    }
}