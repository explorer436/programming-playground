package com.mycompany.inventory.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mycompany.inventory.entities.RecalledCar;


@Repository
public interface RecalledCarRepository extends JpaRepository<RecalledCar, Integer> {}
