package com.example.parking.service;

import com.example.parking.common.model.ParkingSlot;

public interface ParkingSlotService {

    ParkingSlot getParkingSlot(String id);

    ParkingSlot createParkingSlot(ParkingSlot slot);

    ParkingSlot bookParkingSlot(String id);

    ParkingSlot freeParkingSlot(String id);
}