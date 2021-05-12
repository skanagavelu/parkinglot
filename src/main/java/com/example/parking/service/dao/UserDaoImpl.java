package com.example.parking.service.dao;

import java.util.HashMap;
import java.util.Map;

import com.example.parking.common.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    Map<String, User> cache = new HashMap<>();

    @Override
    public User getUser(String id) {

        User user =  cache.get(id);
        return user;
    }

    @Override
    public User createUser(User user) {

        cache.putIfAbsent(user.id, user);
        return cache.get(user.id);
    }

    @Override
    public User updateUser(User user) {

        return cache.put(user.id, user);
    }

    @Override
    public void deleteUser(String id) {
        cache.remove(id);
    }
}
