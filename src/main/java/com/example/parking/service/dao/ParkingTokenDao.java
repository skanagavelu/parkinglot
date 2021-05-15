package com.example.parking.service.dao;

import com.example.parking.common.model.ParkingToken;

public interface ParkingTokenDao {

    ParkingToken get(String id);
    ParkingToken park(ParkingToken token);
    void depart(ParkingToken token);
}
