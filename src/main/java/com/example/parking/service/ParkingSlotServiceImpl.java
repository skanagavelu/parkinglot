package com.example.parking.service;

import java.util.HashMap;
import java.util.Map;

import com.example.parking.common.model.ParkingSlot;
import org.springframework.stereotype.Service;

@Service
public class ParkingSlotServiceImpl implements ParkingSlotService {

    Map<String, ParkingSlot> cache = new HashMap<>();

    @Override
    public ParkingSlot getParkingSlot(String id) {

        return cache.get(id);
    }

    @Override
    public ParkingSlot createParkingSlot(ParkingSlot slot) {

       cache.putIfAbsent(slot.no, slot);
       return cache.get(slot.no);
    }

    @Override
    public ParkingSlot bookParkingSlot(String id) {

        ParkingSlot slot = cache.get(id);
        slot.isBooked = true;
        return cache.get(id);
    }

    @Override
    public ParkingSlot freeParkingSlot(String id) {

        ParkingSlot slot = cache.get(id);
        slot.isBooked = false;
        return cache.get(id);
    }
}
