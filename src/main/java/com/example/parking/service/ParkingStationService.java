package com.example.parking.service;

import com.example.parking.common.model.ParkingStation;
import com.example.parking.common.model.VehicleType;

public interface ParkingStationService {

    ParkingStation getParkingStation(String id);

    ParkingStation createParkingStation(ParkingStation user);

    boolean bookParkingSlot(String parkingStationId, VehicleType type);

    void freeParkingSlot(String parkingStationId, VehicleType type);

    ParkingStation updateParkingStation(ParkingStation user);
    void deleteParkingStation(String id);
}
