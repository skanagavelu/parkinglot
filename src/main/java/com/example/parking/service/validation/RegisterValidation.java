package com.example.parking.service.validation;

import com.example.parking.common.model.RegisterEvent;
import com.example.parking.common.model.User;
import com.example.parking.common.response.utils.Response;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class RegisterValidation {

    public Response isRegistrationValid(RegisterEvent event){

        return new Response(event, HttpStatus.OK);
    }

    public Response isDeRegistrationValid(RegisterEvent event){

        return new Response(event, HttpStatus.OK);
    }
}
