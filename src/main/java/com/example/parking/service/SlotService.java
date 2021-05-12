package com.example.parking.service;

import com.example.parking.common.model.Lot;
import com.example.parking.common.model.VehicleType;

public interface SlotService {

    Lot getLot(String id);

    Lot bookLot(String id, VehicleType type);
}