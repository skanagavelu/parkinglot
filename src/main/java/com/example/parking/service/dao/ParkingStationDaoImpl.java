package com.example.parking.service.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import com.example.parking.common.model.ParkingStation;
import com.example.parking.common.model.VehicleType;
import com.example.parking.common.response.utils.Response;
import com.example.parking.common.response.utils.Response.FailureResponse;
import com.example.parking.common.response.utils.Response.SuccessfulResponse;
import com.example.parking.common.response.utils.ResponseCode;
import org.springframework.stereotype.Repository;

@Repository
public class ParkingStationDaoImpl implements ParkingStationDao {

    Map<String, ParkingStation> cache = new HashMap<>();

    @Override
    public Response<ParkingStation> getParkingStation(String id) {

        ParkingStation parkingStation = cache.get(id);
        if (parkingStation == null) {
            return new FailureResponse<>(ResponseCode.PARKING_STATION_NOT_FOUND);
        }
        return new SuccessfulResponse<>(parkingStation);
    }

    @Override
    public Response<ParkingStation> createParkingStation(ParkingStation parkingStation) {

        cache.putIfAbsent(parkingStation.id, parkingStation);
        ParkingStation station =  cache.get(parkingStation.id);
        return new SuccessfulResponse<>(station);
    }

    @Override
    public ParkingStation updateParkingStation(ParkingStation parkingStation) {

        return cache.put(parkingStation.id, parkingStation);
    }

    @Override
    public void deleteParkingStation(String id) {
        cache.remove(id);
    }

    @Override
    public boolean bookParkingSlot(String parkingStationId, VehicleType type) {

        Response<ParkingStation> response = getParkingStation(parkingStationId);
        AtomicInteger availableSlots = response.getSuccessfulResponse().parkingSlots.get(type);
        AtomicBoolean isUpdateSuccessful = new AtomicBoolean(false);
        availableSlots.updateAndGet( i -> {
            if( i > 0 ) {

                isUpdateSuccessful.getAndSet(true);
                return i - 1;
            } else {

                isUpdateSuccessful.getAndSet(false);
                return i;
            }
        });
        return isUpdateSuccessful.get();
    }

    @Override
    public void freeParkingSlot(String parkingStationId, VehicleType type) {
        Response<ParkingStation> response = getParkingStation(parkingStationId);
        AtomicInteger availableSlots = response.getSuccessfulResponse().parkingSlots.get(type);
        availableSlots.incrementAndGet();
    }
}
