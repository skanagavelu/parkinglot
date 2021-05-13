package com.example.parking.service;

import java.util.Date;

import com.example.parking.common.model.ParkingSlot;
import com.example.parking.common.model.ParkingToken;
import com.example.parking.service.dao.RegisterDao;
import com.example.parking.service.validation.RegisterValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    RegisterValidation validation;

    @Autowired
    ParkingTokenService tokenService;

    @Autowired
    ParkingSlotService slotService;

    @Autowired
    RegisterDao registerDao;

    public ParkingToken register(ParkingToken token){

        if(validation.isRegistrationValid(token).getStatus() == HttpStatus.OK) {
            slotService.bookParkingSlot(token.parkingSlotId);
            return registerDao.register(token);
        } else {

            //TODO: Should return the validation response which contains error code and message for the user
            return  null;
        }
    }

    public ParkingToken deRegister(String parkingTokenId){

        if(validation.isDeRegistrationValid(parkingTokenId).getStatus() == HttpStatus.OK) {
            ParkingToken token = tokenService.getParkingToken(parkingTokenId);
            token.to = new Date();
            token.cost = calculateCost(token.parkingSlotId, token.from);
            slotService.freeParkingSlot(token.parkingSlotId);
            registerDao.deRegister(token);
            return token;
        } else {

            //TODO: Should return the validation response which contains error code and message for the user
            return  null;
        }
    }

    private static int hoursDifference(Date from, Date to) {

        final int MILLI_TO_HOUR = 1000 * 60 * 60;
        return (int) (to.getTime() - from.getTime()) / MILLI_TO_HOUR;
    }

    private double calculateCost(String lotId, Date from) {

        ParkingSlot lot = slotService.getParkingSlot(lotId);
        int hoursUsed = hoursDifference(from, new Date());
        return  lot.type.getCost(hoursUsed);
    }
}
