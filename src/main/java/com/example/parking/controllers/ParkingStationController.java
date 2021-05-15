package com.example.parking.controllers;

import com.example.parking.common.model.ParkingStation;
import com.example.parking.service.ParkingStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.UUID;

@Controller
@RequestMapping("v0")
public class ParkingStationController {

    @Autowired
    final ParkingStationService service = null;

    @RequestMapping(value = "/parkingStations/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getParkingStation(final @PathVariable String id) {

        try {

            ParkingStation parkingStation =  service.getParkingStation(id);
            return ResponseEntity.status(HttpStatus.OK).body(parkingStation);
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @RequestMapping(value = "/parkingStations/", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity createParkingStation(final @RequestBody ParkingStation parkingStation) {
        try {

            parkingStation.id = UUID.randomUUID().toString();
            ParkingStation parkingStationCreated =  service.createParkingStation(parkingStation);
            return ResponseEntity.status(HttpStatus.OK)
                                 .body(parkingStationCreated);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                 .body(null);
        }
    }
}