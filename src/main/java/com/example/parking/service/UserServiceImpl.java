package com.example.parking.service;

import com.example.parking.common.model.User;
import com.example.parking.service.dao.UserDao;
import com.example.parking.service.validation.UserValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserValidation validation;

    @Autowired
    UserDao userDao;

    @Override
    public User getUser(String id) {

        return userDao.getUser(id);
    }

    @Override
    public User createUser(User user) {

        if(validation.isUserValid(user).getStatus() == HttpStatus.OK) {

            return userDao.createUser(user);
        } else {

            //TODO: Should return the validation response which contains error code and message for the user
            return  null;
        }
    }

    @Override
    public User updateUser(User user) {

        return null;
    }

    @Override
    public void deleteUser(String id) {

    }
}
