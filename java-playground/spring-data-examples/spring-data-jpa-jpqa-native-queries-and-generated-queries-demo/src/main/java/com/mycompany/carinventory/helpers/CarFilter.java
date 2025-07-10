package com.mycompany.carinventory.helpers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.mycompany.carinventory.entities.Car;

public class CarFilter {

    private final List<String> recalledCars;

    public CarFilter(List<String> recalledCars) {
        if (recalledCars == null) recalledCars = new ArrayList<>();

        this.recalledCars = recalledCars;
    }

    public List<Car> removeRecalled(Collection<Car> allCars) {
        return allCars.stream().filter(this::isCarInRecalledList).collect(Collectors.toList());
    }

    private boolean isCarInRecalledList(Car car) {
        return !this.recalledCars.contains(car.getName());
    }
}
