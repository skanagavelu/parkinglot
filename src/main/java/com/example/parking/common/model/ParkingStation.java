package com.example.parking.common.model;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Parking station at a geolocation
 */
public class ParkingStation {

    public String id;
    public String name;
    public String address;
    public Map<VehicleType, AtomicInteger> parkingSlots;
}
