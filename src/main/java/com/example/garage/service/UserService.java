package com.example.garage.service;

import com.example.garage.model.Car;
import com.example.garage.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final List<User> users;
    private CarService carService;
    private int counter = 0;

    public UserService(CarService carService) {
        this.carService = carService;
        users = new ArrayList<>();
    }

    public User addUser(User user) {
        user.setId(++counter);
        users.add(user);
        return user;
    }

    public User addCarUser(int id, Car carUser) {
        for (User user : users) {
            if (user.getId() == id) {
                if (!carService.getAllCars().isEmpty()) {
                    for (Car car : carService.getAllCars()) {
                        if (car.getBrand().equals(carUser.getBrand())) {
                            carUser.setId(car.getId());
                            user.getUserCars().add(carUser);
                            return user;
                        }
                    }
                }

                user.getUserCars().add(carService.addCar(carUser));
                return user;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "car not added");
    }

    public User updeteUser(int id, User client) {
        for (User user : users)
            if (user.getId() == id) {
                user.setName(client.getName());
                return user;
            }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "data transferred incorrectly");
    }

    public User getUser(int id) {
        for (User user : users)
            if (user.getId() == id)
                return user;

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found");
    }

    public List<User> getAllUser() {
        if (users.size() != 0)
            return users;

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "customer list is empty");
    }

    public User deleteUser(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                users.remove(user);
                return user;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found");
    }
}