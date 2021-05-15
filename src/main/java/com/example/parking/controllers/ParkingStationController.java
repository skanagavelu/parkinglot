package com.example.parking.controllers;

import com.example.parking.common.model.ParkingStation;
import com.example.parking.common.response.utils.Response;
import com.example.parking.common.response.utils.Response.FailureResponse;
import com.example.parking.common.response.utils.ResponseCode;
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

            Response<ParkingStation> response =  service.getParkingStation(id);
            if (response.code == 0) {
                return ResponseEntity.status(HttpStatus.OK).body(response.getSuccessfulResponse());
            } else {
                return ResponseEntity.status(response.status).body(response.getFailureResponse());
            }
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new FailureResponse<>(
                    ResponseCode.INTERNAL_SERVER_ERROR));
        }
    }

    @RequestMapping(value = "/parkingStations/", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity createParkingStation(final @RequestBody ParkingStation parkingStation) {

        try {

            parkingStation.id = UUID.randomUUID().toString();
            Response<ParkingStation> parkingStationCreated =  service.createParkingStation(parkingStation);
            if (parkingStationCreated.code == 0) {
                return ResponseEntity.status(HttpStatus.OK).body(parkingStationCreated.getSuccessfulResponse());
            } else {
                return ResponseEntity.status(parkingStationCreated.status).body(parkingStationCreated.getFailureResponse());
            }
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new FailureResponse<>(
                    ResponseCode.INTERNAL_SERVER_ERROR));
        }
    }
}