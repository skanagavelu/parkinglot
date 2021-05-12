package com.example.parking.service.dao;

import com.example.parking.common.model.RegisterEvent;
import com.example.parking.common.model.User;

public interface RegisterDao {

    RegisterEvent register(RegisterEvent event);

    void deRegister(RegisterEvent event);


}
