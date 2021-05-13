package com.example.parking.service.dao;

import java.util.HashMap;
import java.util.Map;

import com.example.parking.common.model.ParkingToken;
import org.springframework.stereotype.Repository;

@Repository
public class RegisterDaoImpl implements RegisterDao {

    Map<String, ParkingToken> cache = new HashMap<>();

    @Override
    public ParkingToken register(ParkingToken token) {

        cache.put(token.tokenId, token);
        return cache.get(token.tokenId);
    }

    @Override
    public void deRegister(ParkingToken token) {
        cache.put(token.tokenId, token);
    }
}
