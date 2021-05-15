package com.example.parking.common.model;

import java.util.Date;

public class ParkingToken {

    public String tokenId; //ReadOnly: Set by Server
    public String parkingStationId;
    public VehicleType type;
    public Date from;  //ReadOnly: Set by Server
    public Date to;  //ReadOnly: Set by Server
    public String vehicleNo;
    public double cost; //ReadOnly: Set by Server
}
