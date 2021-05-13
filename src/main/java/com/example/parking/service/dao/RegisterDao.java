package com.example.parking.service.dao;

import com.example.parking.common.model.ParkingToken;

public interface RegisterDao {

    ParkingToken register(ParkingToken token);

    void deRegister(ParkingToken token);


}
