package com.example.parking.service.dao;

import com.example.parking.common.model.User;

public interface UserDao {

    User getUser(String id);
    User createUser(User user);
    User updateUser(User user);
    void deleteUser(String id);
}
