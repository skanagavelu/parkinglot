package com.example.parking.common.model;

import java.util.List;

/**
 * Parking station at a geolocation
 */
public class ParkingStation {

    public String id;
    public String name;
    public String address;
    public List<ParkingSlot> parkingSlots;
}
