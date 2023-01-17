package com.mycompany.carinventory.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mycompany.carinventory.entities.RecalledCar;


@Repository
public interface RecalledCarRepository extends JpaRepository<RecalledCar, Integer> {}
