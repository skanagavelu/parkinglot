package com.example.parking.service;

import java.util.Date;

import com.example.parking.common.model.Lot;
import com.example.parking.common.model.RegisterEvent;
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
    SlotService slotService;

    @Autowired
    RegisterDao registerDao;

    public RegisterEvent register(RegisterEvent event){

        if(validation.isRegistrationValid(event).getStatus() == HttpStatus.OK) {
            slotService.getLot(event.slotId);
            return registerDao.register(event);
        } else {

            //TODO: Should return the validation response which contains error code and message for the user
            return  null;
        }
    }

    public RegisterEvent deRegister(RegisterEvent event){

        if(validation.isDeRegistrationValid(event).getStatus() == HttpStatus.OK) {
            event.to = new Date();
            event.cost = calculateCost(event.slotId, event.from);
            registerDao.deRegister(event);
            return event;
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

        Lot lot = slotService.getLot(lotId);
        int hoursUsed = hoursDifference(from, new Date());
        return  lot.type.getCost(hoursUsed);
    }
}
