package com.example.parking.service.dao;

import java.util.HashMap;
import java.util.Map;

import com.example.parking.common.model.ParkingStation;
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
}
