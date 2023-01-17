package com.mycompany.carinventory.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mycompany.carinventory.entities.Car;


@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {}
