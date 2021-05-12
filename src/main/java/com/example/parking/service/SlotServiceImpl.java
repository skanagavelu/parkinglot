package com.example.parking.service;

import java.util.HashMap;
import java.util.Map;

import com.example.parking.common.model.Lot;
import com.example.parking.common.model.VehicleType;
import org.springframework.stereotype.Service;

@Service
public class SlotServiceImpl implements SlotService {

    Map<String, Lot> cache = new HashMap<>();

    @Override
    public Lot getLot(String id) {

        cache.putIfAbsent(id, new Lot(id, true, VehicleType.BIKE));
        return cache.get(id);
    }

    @Override
    public Lot bookLot(String id, VehicleType type) {

        cache.put(id, new Lot(id, true, type));
        return cache.get(id);
    }
}
