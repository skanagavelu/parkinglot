package com.example.parking.common.model;

public enum VehicleType {

    CAR {   //Should be class for inheritance
        @Override
        public double getCost(int hours) {

            if (hours < 2) {

                return 30;
            } else if (hours < 4) {

                return 70;
            } else if (hours < 24) {

                return 100;
            } else {

                int days = hours / 24;
                return days * 100;
            }
        }
    },
    BIKE {
        @Override
        public double getCost(int hours) {

            if (hours < 2) {

                return 20;
            } else if (hours < 4) {

                return 50;
            } else if (hours < 24) {

                return 80;
            } else {

                int days = hours / 24;
                return days * 80;
            }
        }
    };

    public abstract double getCost(int hours);
}
