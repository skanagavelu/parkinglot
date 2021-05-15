package com.example.parking.service.validation;

import com.example.parking.common.model.ParkingStation;
import com.example.parking.common.response.utils.Response;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ParkingStationValidation {

    public Response isParkingStationValid(ParkingStation parkingStation){

        return new Response(parkingStation, HttpStatus.OK);
    }
}
