package com.example.garage.controller;

import com.example.garage.model.Car;
import com.example.garage.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/{id}")
    public String getCar (@PathVariable int id, Model model){
        model.addAttribute("car", carService.getCar(id));
        return "car";
    }

    @GetMapping
    public String getAllCar (Model model){
        model.addAttribute("cars", carService.getAllCars());
        return "cars";
    }

    @PostMapping
    public String addCar (@RequestBody Car car, Model model){
        model.addAttribute("car", carService.addCar(car));
        return "car";
    }

    @PutMapping("/{id}")
    public String updateCar (@PathVariable int id, @RequestBody Car car, Model model){
        model.addAttribute("car", carService.updateCar(id, car));
        return "car";
    }

    @DeleteMapping("/{id}")
    public String deleteCar (@PathVariable int id, Model model){
        model.addAttribute("car", carService.deleteCar(id));
        return "car";
    }
}
