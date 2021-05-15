package com.example.parking.service;

import java.util.List;

import com.example.parking.common.model.ParkingSlot;
import org.springframework.stereotype.Service;

@Service
public class ParkingSlotServiceImpl implements ParkingSlotService {

    @Override
    public ParkingSlot getParkingSlot(String parkingStationId, String id) {

        return null;
    }

    @Override
    public List<ParkingSlot> getAllParkingSlots(String parkingStationId) {

        return null;
    }

    @Override
    public ParkingSlot bookParkingSlot(String id) {

        return null;
    }

    @Override
    public ParkingSlot freeParkingSlot(String id) {

        return null;
    }
}
