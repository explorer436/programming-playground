package com.mycompany.inventory;

import java.util.Collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mycompany.inventory.entities.Car;
import com.mycompany.inventory.entities.RecalledCar;
import com.mycompany.inventory.services.CarService;
import com.mycompany.inventory.services.RecalledCarService;

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
        Car car = createTestCar("car1", 1.2, 2);

        Car savedCar = carService.save(car);

        Car loadedCar = carService.findById(savedCar.getId()).orElse(null);

        Assertions.assertNotNull(loadedCar);
        Assertions.assertNotNull(loadedCar.getId());
        // Assertions.assertEquals(1, carService.getAllCars().size());
    }

    @Test
    void shouldUpdateCar() {
        Car car = createTestCar("car2", 1.3, 5);

        Car savedCar = carService.save(car);

        Car loadedCar = carService.findById(savedCar.getId()).orElse(null);

        Assertions.assertNotNull(loadedCar);

        loadedCar.setName("NewCar");

        carService.save(loadedCar);

        Car updatedCar = carService.findById(loadedCar.getId()).orElse(null);
        Assertions.assertNotNull(updatedCar);
    }
    
    @Test
    void shouldGetAllCars() {
    	
        Car car1 = createTestCar("carA", 1.2, 2);
        Car car2 = createTestCar("carB", 1.2, 2);
        Car car3 = createTestCar("carC", 1.2, 2);
        Car car4 = createTestCar("carD", 1.2, 2);
        
        carService.save(car1);
        carService.save(car2);
        carService.save(car3);
        carService.save(car4);

        Collection<Car> savedCars = carService.getAllCars();
        Assertions.assertNotNull(savedCars);
        Assertions.assertEquals(4, savedCars.size());
        
        RecalledCar recalledCar1 = createTestRecalledCar("carA");
        recalledCarService.save(recalledCar1);
        
        Collection<RecalledCar> recalledCars = recalledCarService.getAllRecalledCars();

        Assertions.assertNotNull(recalledCars);
        Assertions.assertEquals(1, recalledCars.size());
        
        Collection<Car> savedCarsAfterSavingSomeRecalledCars = carService.getAllCars();
        Assertions.assertNotNull(savedCarsAfterSavingSomeRecalledCars);
        Assertions.assertEquals(3, savedCarsAfterSavingSomeRecalledCars.size());
        
    }
}
