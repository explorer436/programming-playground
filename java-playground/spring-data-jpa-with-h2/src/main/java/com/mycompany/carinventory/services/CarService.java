package com.mycompany.carinventory.services;

import com.mycompany.carinventory.entities.Car;
import com.mycompany.carinventory.helpers.CarFilter;
import com.mycompany.carinventory.repositories.CarRepository;
import com.mycompany.carinventory.repositories.RecalledCarRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carInventoryRepository;
    
    private final RecalledCarRepository recalledCarRepository;

    public Car saveCar(Car car) {
        return carInventoryRepository.save(car);
    }

    public List<Car> saveCars(List<Car> cars) {
        return carInventoryRepository.saveAll(cars);
    }

    public Collection<Car> getAllCars() {
    	List<String> recalledCarNames = recalledCarRepository.findAll().stream().map(rp -> rp.getName()).collect(Collectors.toList());
        CarFilter filter = new CarFilter(recalledCarNames);
        return filter.removeRecalled(carInventoryRepository.findAll());
    }

    public Optional<Car> findById(Integer id) {
        return carInventoryRepository.findById(id);
    }
}
