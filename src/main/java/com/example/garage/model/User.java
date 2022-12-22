package com.example.garage.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class User {

    private int id;
    private String name;
    private List<Car> userCars;

    public User() {
        userCars = new ArrayList<>();
    }

}
