package com.example.parking.common.model;

import java.util.Date;

public class ParkingToken {

    public String tokenId;
    public String parkingStationId;
    public String parkingSlotId;
    public Date from;
    public Date to;  //ReadOnly: Set by Server
    public String vehicleNo;
    public double cost; //ReadOnly: Set by Server
}
