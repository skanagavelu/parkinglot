package com.example.parking.service;

import com.example.parking.common.model.User;

public interface UserService {

    User getUser(String id);
    User createUser(User user);
    User updateUser(User user);
    void deleteUser(String id);
}
