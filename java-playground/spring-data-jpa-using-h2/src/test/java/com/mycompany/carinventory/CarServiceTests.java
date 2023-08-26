package com.mycompany.carinventory;

import java.util.Collection;
import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mycompany.carinventory.entities.Car;
import com.mycompany.carinventory.entities.RecalledCar;
import com.mycompany.carinventory.services.CarService;
import com.mycompany.carinventory.services.RecalledCarService;

@SpringBootTest
class CarServiceTests {

    @Autowired
    CarService carService;

    @Autowired
    RecalledCarService recalledCarService;

    /**
     * Helper method to create test cars
     */
    private Car createTestCar(String carName, Double price, Integer quantity) {
        return Car.builder()
                .name(carName)
                .price(price)
                .quantity(quantity)
                .build();
    }

    /**
     * Helper method to create test recalled cars
     */
    private RecalledCar createTestRecalledCar(String recalledCarName) {
        return RecalledCar.builder()
                .name(recalledCarName)
                .build();
    }

    @Test
    void shouldSaveCar() {
        Car car = createTestCar("car1" + UUID.randomUUID().toString(), 1.2, 2);

        Car savedCar = carService.saveCar(car);

        Car loadedCar = carService.findById(savedCar.getId()).orElse(null);

        Assertions.assertNotNull(loadedCar);
        Assertions.assertNotNull(loadedCar.getId());
        // Assertions.assertEquals(1, carService.getAllCars().size());
    }

    @Test
    void shouldUpdateCar() {
        Car car = createTestCar("car2" + UUID.randomUUID().toString(), 1.3, 5);

        Car savedCar = carService.saveCar(car);

        Car loadedCar = carService.findById(savedCar.getId()).orElse(null);

        Assertions.assertNotNull(loadedCar);

        loadedCar.setName("NewCar");

        carService.saveCar(loadedCar);

        Car updatedCar = carService.findById(loadedCar.getId()).orElse(null);
        Assertions.assertNotNull(updatedCar);
    }
    
    @Test
    void shouldGetAllCars() {
    	
        Car car1 = createTestCar("car1" + UUID.randomUUID().toString(), 1.2, 2);
        Car car2 = createTestCar("car2" + UUID.randomUUID().toString(), 1.2, 2);
        Car car3 = createTestCar("car3" + UUID.randomUUID().toString(), 1.2, 2);
        Car car4 = createTestCar("car4" + UUID.randomUUID().toString(), 1.2, 2);
        
        carService.saveCar(car1);
        carService.saveCar(car2);
        carService.saveCar(car3);
        carService.saveCar(car4);

        Collection<Car> savedCars = carService.getAllCars();
        Assertions.assertNotNull(savedCars);
        Assertions.assertEquals(7, savedCars.size());
        
        RecalledCar recalledCar1 = createTestRecalledCar("carA" + UUID.randomUUID().toString());
        recalledCarService.save(recalledCar1);
        
        Collection<RecalledCar> recalledCars = recalledCarService.getAllRecalledCars();

        Assertions.assertNotNull(recalledCars);
        Assertions.assertEquals(2, recalledCars.size());
        
        Collection<Car> savedCarsAfterSavingSomeRecalledCars = carService.getAllCars();
        Assertions.assertNotNull(savedCarsAfterSavingSomeRecalledCars);
        Assertions.assertEquals(7, savedCarsAfterSavingSomeRecalledCars.size());
        
    }
}
