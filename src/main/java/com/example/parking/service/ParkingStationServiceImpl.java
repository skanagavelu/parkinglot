package com.example.parking.service;

import com.example.parking.common.model.ParkingStation;
import com.example.parking.common.model.VehicleType;
import com.example.parking.common.response.utils.Response;
import com.example.parking.service.dao.ParkingStationDao;
import com.example.parking.service.validation.ParkingStationValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ParkingStationServiceImpl implements ParkingStationService {

    @Autowired
    ParkingStationValidation validation;

    @Autowired
    ParkingStationDao parkingStationDao;

    @Override
    public Response<ParkingStation> getParkingStation(String id) {

        return parkingStationDao.getParkingStation(id);
    }

    @Override
    public Response<ParkingStation> createParkingStation(ParkingStation parkingStation) {

        Response<ParkingStation> response = validation.isParkingStationValid(parkingStation);
        if(response.status == HttpStatus.OK) {

            response = parkingStationDao.createParkingStation(parkingStation);
        }
        return response;
    }

    @Override
    public ParkingStation updateParkingStation(ParkingStation user) {

        return null;
    }

    @Override
    public void deleteParkingStation(String id) {

    }

    @Override
    public boolean bookParkingSlot(String parkingStationId, VehicleType type) {

        return parkingStationDao.bookParkingSlot(parkingStationId, type);
    }

    @Override
    public void freeParkingSlot(String parkingStationId, VehicleType type) {

         parkingStationDao.freeParkingSlot(parkingStationId, type);
    }
}
