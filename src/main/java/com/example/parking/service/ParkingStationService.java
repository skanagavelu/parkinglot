package com.example.parking.service;

import com.example.parking.common.model.ParkingStation;
import com.example.parking.common.model.VehicleType;
import com.example.parking.common.response.utils.Response;

public interface ParkingStationService {

    Response<ParkingStation> getParkingStation(String id);

    Response<ParkingStation> createParkingStation(ParkingStation user);

    boolean bookParkingSlot(String parkingStationId, VehicleType type);

    void freeParkingSlot(String parkingStationId, VehicleType type);

    ParkingStation updateParkingStation(ParkingStation user);
    void deleteParkingStation(String id);
}
