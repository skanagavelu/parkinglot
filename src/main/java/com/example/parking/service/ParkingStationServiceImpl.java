package com.example.parking.service;

import com.example.parking.common.model.ParkingStation;
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
    public ParkingStation getParkingStation(String id) {

        return parkingStationDao.getParkingStation(id);
    }

    @Override
    public ParkingStation createParkingStation(ParkingStation parkingLot) {

        if(validation.isParkingStationValid(parkingLot).getStatus() == HttpStatus.OK) {

            return parkingStationDao.createParkingStation(parkingLot);
        } else {

            //TODO: Should return the validation response which contains error code and message for the user
            return  null;
        }
    }

    @Override
    public ParkingStation updateParkingStation(ParkingStation user) {

        return null;
    }

    @Override
    public void deleteParkingStation(String id) {

    }
}