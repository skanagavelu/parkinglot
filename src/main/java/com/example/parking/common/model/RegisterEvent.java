package com.example.parking.common.model;

import java.util.Date;

public class RegisterEvent {

    public String id;
    public String cardId;
    public String slotId;
    public Date from;
    public Date to;
    public String vehicleNo;
    public double cost; //ReadOnly
}
