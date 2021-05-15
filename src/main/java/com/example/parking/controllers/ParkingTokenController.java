package com.example.parking.controllers;

import java.util.Date;
import java.util.UUID;

import com.example.parking.common.model.ParkingToken;
import com.example.parking.service.ParkingTokenService;
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
public class ParkingTokenController {

    @Autowired
    ParkingTokenService service;

    @RequestMapping(value = "/parkingTokens/park/", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity park(final @RequestBody ParkingToken token) {
        try {

            token.tokenId = UUID.randomUUID().toString();
            token.from = new Date();
            ParkingToken tokenCreated =  service.park(token);
            return ResponseEntity.status(HttpStatus.OK).body(tokenCreated);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                 .body(null);
        }
    }

    @RequestMapping(value = "/parkingTokens/depart/{parkingTokenId}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity depart(final @PathVariable String parkingTokenId) {
        try {

            ParkingToken token =  service.depart(parkingTokenId);
            return ResponseEntity.status(HttpStatus.OK)
                                 .body(token);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                 .body(null);
        }
    }

    @RequestMapping(value = "/parkingTokens/{parkingTokenId}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity get(final @PathVariable String parkingTokenId) {
        try {

            ParkingToken token =  service.get(parkingTokenId);
            return ResponseEntity.status(HttpStatus.OK)
                                 .body(token);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                 .body(null);
        }
    }
}