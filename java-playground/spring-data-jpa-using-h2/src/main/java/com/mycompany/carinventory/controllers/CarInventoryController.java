package com.mycompany.carinventory.controllers;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.carinventory.entities.Car;
import com.mycompany.carinventory.services.CarService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/inventory")
public class CarInventoryController {

    private final CarService carService;

    /**
     *
     * @return all the cars that are not recalled
     */
    @GetMapping@PostMapping("/car")
    public ResponseEntity<Collection<Car>> getAllCars() {
        return ResponseEntity.ok(carService.getAllCars());
    }

    @PostMapping("/car")
    public ResponseEntity<Car> createCar(@RequestBody Car car) {
        return ResponseEntity.ok(carService.saveCar(car));
    }

    @PostMapping("/cars")
    public ResponseEntity<List<Car>> createCars(@RequestBody List<Car> cars) {
        return ResponseEntity.ok(carService.saveCars(cars));
    }

    @GetMapping("/car/{id}")
    ResponseEntity<Car> findCar(@PathVariable Integer id) {
        Optional<Car> byId = carService.findById(id);

        return byId.map(ResponseEntity::ok).orElse(null);
    }
}
