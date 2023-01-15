package com.mycompany.inventory.controllers;

import java.util.Collection;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.inventory.entities.Car;
import com.mycompany.inventory.services.CarService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/inventory/car")
public class CarInventoryController {

    private final CarService carService;

    /**
     *
     * @return all the cars that are not recalled
     */
    @GetMapping
    public ResponseEntity<Collection<Car>> getAllCars() {
        return ResponseEntity.ok(carService.getAllCars());
    }

    @PostMapping
    public ResponseEntity<Car> createCar(@RequestBody Car car) {
        return ResponseEntity.ok(carService.save(car));
    }

    @GetMapping("/{id}")
    ResponseEntity<Car> findCar(@PathVariable Integer id) {
        Optional<Car> byId = carService.findById(id);

        return byId.map(ResponseEntity::ok).orElse(null);
    }
}
