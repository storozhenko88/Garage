package com.example.garage.controller;

import com.example.garage.model.Car;
import com.example.garage.model.User;
import com.example.garage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {


    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public String getUser(@PathVariable int id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "user";
    }

    @GetMapping("/{id}/cars")
    public String getUserCars(@PathVariable int id, Model model) {
        model.addAttribute("cars", userService.getUser(id).getUserCars());
        return "user_cars";
    }

    @GetMapping
    public String getAllUser(Model model) {
        model.addAttribute("users", userService.getAllUser());
        return "users";
    }

    @PostMapping
    public String addUser(@RequestBody User user, Model model) {
        model.addAttribute("user", userService.addUser(user));
        return "user";
    }

    @PutMapping("/{id}/car")
    public String addCarUser(@PathVariable int id, @RequestBody Car car, Model model){
        model.addAttribute("user", userService.addCarUser(id, car));
       return "user";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id, Model model) {
        model.addAttribute("user", userService.deleteUser(id));
        return "user";
    }


}
