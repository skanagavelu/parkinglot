package com.example.parking.service.validation;

import com.example.parking.common.model.User;
import com.example.parking.common.response.utils.Response;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserValidation {

    public Response isUserValid(User user){

        return new Response(user, HttpStatus.OK);
    }
}
