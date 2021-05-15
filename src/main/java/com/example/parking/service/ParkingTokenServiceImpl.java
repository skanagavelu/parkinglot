package com.example.parking.service;

import java.util.Date;

import com.example.parking.common.model.ParkingToken;
import com.example.parking.common.model.VehicleType;
import com.example.parking.service.dao.ParkingTokenDao;
import com.example.parking.service.validation.ParkingTokenValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ParkingTokenServiceImpl implements ParkingTokenService {

    @Autowired
    ParkingTokenValidation validation;

    @Autowired
    ParkingStationService parkingStationService;

    @Autowired
    ParkingTokenDao parkingTokenDao;

    @Override
    public ParkingToken get(String id) {

        return parkingTokenDao.get(id);
    }

    public ParkingToken park(ParkingToken token) {

        if (validation.isRegistrationValid(token).getStatus() == HttpStatus.OK) {

            parkingStationService.bookParkingSlot(token.parkingStationId, token.type);
            return parkingTokenDao.park(token);
        } else {

            //TODO: Should return the validation response which contains error code and message for the user
            return  null;
        }
    }

    public ParkingToken depart(String parkingTokenId){

        if(validation.isDeRegistrationValid(parkingTokenId).getStatus() == HttpStatus.OK) {
            ParkingToken token = parkingTokenDao.get(parkingTokenId);
            token.to = new Date();
            token.cost = calculateCost(token.type, token.from);
            parkingStationService.freeParkingSlot(token.parkingStationId, token.type);
            parkingTokenDao.depart(token);
            return token;
        } else {

            //TODO: Should return the validation response which contains error code and message for the user
            return  null;
        }
    }

    private double calculateCost(VehicleType type, Date from) {

        int hoursUsed = hoursDifference(from, new Date());
        return  type.getCost(hoursUsed);
    }

    private static int hoursDifference(Date from, Date to) {

        final int MILLI_TO_HOUR = 1000 * 60 * 60;
        return (int) (to.getTime() - from.getTime()) / MILLI_TO_HOUR;
    }
}
