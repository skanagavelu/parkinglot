package com.example.parking.common.model;

/**
 * Represents parking slot area allocated per {@link ParkingToken}
 * Currently not supported
 */
public class ParkingSlot {

    public ParkingSlot(String no, boolean isBooked, VehicleType type) {

        this.no = no;
        this.isBooked = isBooked;
        this.type = type;
    }

    public String no;
    public boolean isBooked;
    public VehicleType type;
}
