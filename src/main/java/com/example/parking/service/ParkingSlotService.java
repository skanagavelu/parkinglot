package com.example.parking.service;

import java.util.List;

import com.example.parking.common.model.ParkingSlot;

public interface ParkingSlotService {

    ParkingSlot getParkingSlot(String parkingStationId, String id);

    List<ParkingSlot> getAllParkingSlots(String parkingStationId);

    ParkingSlot bookParkingSlot(String id);

    ParkingSlot freeParkingSlot(String id);
}