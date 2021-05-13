package com.example.parking.service;

import com.example.parking.common.model.ParkingStation;

public interface ParkingStationService {

    ParkingStation getParkingStation(String id);
    ParkingStation createParkingStation(ParkingStation user);
    ParkingStation updateParkingStation(ParkingStation user);
    void deleteParkingStation(String id);
}
