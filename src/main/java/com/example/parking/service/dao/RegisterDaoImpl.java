package com.example.parking.service.dao;

import java.util.HashMap;
import java.util.Map;

import com.example.parking.common.model.RegisterEvent;
import com.example.parking.common.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class RegisterDaoImpl implements RegisterDao {

    Map<String, RegisterEvent> cache = new HashMap<>();

    @Override
    public RegisterEvent register(RegisterEvent event) {

        cache.put(event.cardId, event);
        return cache.get(event.cardId);
    }

    @Override
    public void deRegister(RegisterEvent event) {
        cache.put(event.cardId, event);
    }
}
