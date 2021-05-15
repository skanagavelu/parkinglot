package com.example.parking.service.dao;

import java.util.HashMap;
import java.util.Map;

import com.example.parking.common.model.ParkingToken;
import org.springframework.stereotype.Repository;

@Repository
public class ParkingTokenDaoImpl implements ParkingTokenDao {

    Map<String, ParkingToken> cache = new HashMap<>();

    @Override
    public ParkingToken get(String id) {

        return cache.get(id);
    }

    @Override
    public ParkingToken park(ParkingToken token) {

        cache.put(token.tokenId, token);
        return cache.get(token.tokenId);
    }

    @Override
    public void depart(ParkingToken token) {
        cache.put(token.tokenId, token);
    }
}
