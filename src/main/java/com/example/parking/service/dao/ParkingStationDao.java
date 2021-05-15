package com.example.parking.service.dao;

import com.example.parking.common.model.ParkingStation;
import com.example.parking.common.model.VehicleType;
import com.example.parking.common.response.utils.Response;

public interface ParkingStationDao {

    Response<ParkingStation> getParkingStation(String id);
    Response<ParkingStation> createParkingStation(ParkingStation parkingStation);
    boolean bookParkingSlot(String parkingStationId, VehicleType type);
    void freeParkingSlot(String parkingStationId, VehicleType type);

    ParkingStation updateParkingStation(ParkingStation parkingStation);
    void deleteParkingStation(String id);
}
