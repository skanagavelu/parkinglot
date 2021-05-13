package com.example.parking.service;

import com.example.parking.common.model.ParkingToken;

public interface RegisterService {

    ParkingToken register(ParkingToken token);
    ParkingToken deRegister(String parkingTokenId);
}
