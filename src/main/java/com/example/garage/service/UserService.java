package com.example.garage.service;

import com.example.garage.model.Car;
import com.example.garage.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

  private final List<User> users = new ArrayList<>();
    private int counter = 0;
 //   private List<User> users;

    public UserService() {
//        users = new ArrayList<>();
//
//        User user1 = new User();
//        user1.setId(1);
//        user1.setName("dima");
//      //  List<Car> car1 = List.of(new Car(1, "bmw"), new Car(2, "audi"), new Car(3, "jip"));
//        List<Car> car1 = new ArrayList<>();
//        car1.add(new Car(1, "bmw"));
//        car1.add(new Car(2, "audi"));
//        car1.add(new Car(3, "jip"));
//        user1.setUserCars(car1);
//
//        User user2 = new User();
//        user2.setId(2);
//        user2.setName("kiril");
//   //     List<Car> car2 = List.of(new Car(1, "bmw"), new Car(2, "audi"), new Car(3, "jip"));
//        List<Car> car2 = new ArrayList<>();
//        car2.add(new Car(1, "bmw2"));
//        car2.add(new Car(2, "audi2"));
//        car2.add(new Car(3, "jip2"));
//        user2.setUserCars(car2);
//
//        users.add(user1);
//        users.add(user2);
    }


    public User addUser(User user) {
        user.setId(++counter);
        users.add(user);
        return user;
    }

    public User addCarUser(int id, Car carUser) {
        for (User user : users) {
            if (user.getId() == id) {
                int count = user.getUserCars().size() + 1;
                carUser.setId(count);
//                user.addCar(car);
                user.getUserCars().add(carUser);
                return user;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "car not added");
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