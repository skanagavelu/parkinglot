package com.example.parking.service;

import com.example.parking.common.model.RegisterEvent;

public interface RegisterService {

    RegisterEvent register(RegisterEvent event);
    RegisterEvent deRegister(RegisterEvent event);
}
