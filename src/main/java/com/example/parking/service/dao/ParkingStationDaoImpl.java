package com.example.parking.service.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import com.example.parking.common.model.ParkingStation;
import com.example.parking.common.model.VehicleType;
import org.springframework.stereotype.Repository;

@Repository
public class ParkingStationDaoImpl implements ParkingStationDao {

    Map<String, ParkingStation> cache = new HashMap<>();

    @Override
    public ParkingStation getParkingStation(String id) {

        ParkingStation parkingStation =  cache.get(id);
        return parkingStation;
    }

    @Override
    public ParkingStation createParkingStation(ParkingStation parkingStation) {

        cache.putIfAbsent(parkingStation.id, parkingStation);
        return cache.get(parkingStation.id);
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

        ParkingStation station = getParkingStation(parkingStationId);
        AtomicInteger availableSlots = station.parkingSlots.get(type);
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
        ParkingStation station = getParkingStation(parkingStationId);
        AtomicInteger availableSlots = station.parkingSlots.get(type);
        availableSlots.incrementAndGet();
    }
}
