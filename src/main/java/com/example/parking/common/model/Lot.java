package com.example.parking.common.model;

import java.util.Objects;

public class Lot {

    public Lot(String no, boolean isBooked, VehicleType type) {

        this.no = no;
        this.isBooked = isBooked;
        this.type = type;
    }

    public String no;
    public boolean isBooked;
    public VehicleType type;

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lot lot = (Lot) o;
        return isBooked == lot.isBooked && Objects.equals(no, lot.no) && type == lot.type;
    }

    @Override
    public int hashCode() {

        return Objects.hash(no, isBooked, type);
    }
}
