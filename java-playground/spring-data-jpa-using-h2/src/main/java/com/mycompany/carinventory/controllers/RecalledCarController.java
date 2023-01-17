package com.mycompany.carinventory.controllers;

import com.mycompany.carinventory.entities.RecalledCar;
import com.mycompany.carinventory.services.RecalledCarService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/inventory/recalled")
public class RecalledCarController {

    private final RecalledCarService recalledCarService;

    @PostMapping
    public ResponseEntity<RecalledCar> createRecalledCar(@RequestBody RecalledCar recalledCar) {
        return ResponseEntity.ok(recalledCarService.save(recalledCar));
    }

    @GetMapping("/")
    ResponseEntity<Collection<RecalledCar>> findRecalledCars() {
        Collection<RecalledCar> allRecalledCars = recalledCarService.getAllRecalledCars();

        return ResponseEntity.ok(allRecalledCars);
    }
}
