package com.example.garage.model;

import lombok.Data;

@Data
public class Car {

    private int id;
    private String brand;

    public Car(int id, String brand) {
        this.id = id;
        this.brand = brand;
    }
}
