package com.example.parking.common.model;

public class User {

    public String id;
    public String name;
    public String address;

    @Override
    public String toString() {

        return "User{" +
               "id='" + id + '\'' +
               ", name='" + name + '\'' +
               ", address='" + address + '\'' +
               '}';
    }
}
