package com.example.parking.service.validation;

import com.example.parking.common.model.ParkingToken;
import com.example.parking.common.response.utils.Response;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class RegisterValidation {

    public Response isRegistrationValid(ParkingToken token){

        return new Response(token, HttpStatus.OK);
    }

    public Response isDeRegistrationValid(String parkingTokenId){

        return new Response(null, HttpStatus.OK);
    }
}
