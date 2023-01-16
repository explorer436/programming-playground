package com.mycompany.inventory.services;

import com.mycompany.inventory.entities.RecalledCar;
import com.mycompany.inventory.repositories.RecalledCarRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RecalledCarService {

    private final RecalledCarRepository recalledCarRepository;

    public RecalledCar save(RecalledCar recalledCar) {
        return recalledCarRepository.save(recalledCar);
    }

    public Collection<RecalledCar> getAllRecalledCars() {
        return recalledCarRepository.findAll();
    }

    public Optional<RecalledCar> findById(Integer id) {
        return recalledCarRepository.findById(id);
    }
}
