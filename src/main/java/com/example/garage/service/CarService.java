package com.example.garage.service;

import com.example.garage.model.Car;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;

@Service
public class CarService {

    private List<Car> cars;
    private int count = 1;

    public CarService() {
        cars = new ArrayList<>();
    }

    public Car addCar(Car auto) {
        for (Car car : cars) {
            if (car.getBrand().equals(auto.getBrand()))
                throw new ResponseStatusException(
                        HttpStatus.CONFLICT, "this car is already in the list");
        }
        auto.setId(count);
        count++;
        cars.add(auto);
        return auto;

    }

    public Car getCar(int id) {
        for (Car car : cars) {
            if (car.getId() == id)
                return car;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "car not found");
    }

    public List<Car> getAllCars() {
        if (cars.size() != 0)
            return cars;
        else
            return new ArrayList<>();
    }

    public Car updateCar(int id, Car auto) {
        for (Car car : cars) {
            if (car.getId() == id) {
                car.setBrand(auto.getBrand());
                return car;
            }
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "data transferred incorrectly");
    }

    public Car deleteCar(int id) {
        for (Car car : cars) {
            if (car.getId() == id) {
                cars.remove(car);
                return car;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "car not found");
    }
}