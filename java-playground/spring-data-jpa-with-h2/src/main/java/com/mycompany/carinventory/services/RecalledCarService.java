package com.mycompany.carinventory.services;

import com.mycompany.carinventory.dto.RecalledCarDto;
import com.mycompany.carinventory.entities.RecalledCar;
import com.mycompany.carinventory.repositories.RecalledCarRepository;

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

    public Collection<RecalledCarDto> findRecalledCarsAndInventoryDetails() {
        return recalledCarRepository.findRecalledCarsAndInventoryDetails();
    }

    public Optional<RecalledCar> findById(Integer id) {
        return recalledCarRepository.findById(id);
    }
}
