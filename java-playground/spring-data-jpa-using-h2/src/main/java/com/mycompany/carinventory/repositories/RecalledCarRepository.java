package com.mycompany.carinventory.repositories;

import com.mycompany.carinventory.dto.RecalledCarDto;
import com.mycompany.tutorial.model.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mycompany.carinventory.entities.RecalledCar;

import java.util.List;


@Repository
public interface RecalledCarRepository extends JpaRepository<RecalledCar, Integer> {

    @Query(value = "SELECT RC.ID as rcId, RC.NAME as rcName, RC.REASON_FOR_RECALL as rcReasonForRecall, \n" +
            "C.ID as cId, C.PRICE as cPrice, C.QUANTITY as cQuantity FROM RECALLED_CAR RC \n" +
            "LEFT JOIN CAR C ON C.NAME = RC.NAME",
            nativeQuery = true)
    List<RecalledCarDto> findRecalledCarsAndInventoryDetails();
}
