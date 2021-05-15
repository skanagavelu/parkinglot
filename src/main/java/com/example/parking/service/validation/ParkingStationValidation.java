package com.example.parking.service.validation;

import com.example.parking.common.model.ParkingStation;
import com.example.parking.common.response.utils.Response;
import org.springframework.stereotype.Service;

@Service
public class ParkingStationValidation {

    public Response<ParkingStation> isParkingStationValid(ParkingStation parkingStation){

        return new Response<>(parkingStation);
    }
}
