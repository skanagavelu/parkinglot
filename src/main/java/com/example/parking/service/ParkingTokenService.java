package com.example.parking.service;

import com.example.parking.common.model.ParkingToken;
import org.springframework.stereotype.Service;

@Service
public interface ParkingTokenService {

    ParkingToken get(String parkingTokenId);
    ParkingToken park(ParkingToken token);
    ParkingToken depart(String parkingTokenId);
}