package com.example.parking.service.dao;

import com.example.parking.common.model.ParkingStation;

public interface ParkingStationDao {

    ParkingStation getParkingStation(String id);
    ParkingStation createParkingStation(ParkingStation parkingStation);
    ParkingStation updateParkingStation(ParkingStation parkingStation);
    void deleteParkingStation(String id);
}
