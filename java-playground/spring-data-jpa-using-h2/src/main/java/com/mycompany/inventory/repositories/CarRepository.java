package com.mycompany.inventory.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mycompany.inventory.entities.Car;


@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {}
