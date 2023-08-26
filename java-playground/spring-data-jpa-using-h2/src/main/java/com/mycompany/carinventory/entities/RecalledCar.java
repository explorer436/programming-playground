package com.mycompany.carinventory.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecalledCar {
    @Id
    @GeneratedValue
    Integer id;

    @Column(unique=true)
    String name;

    @Column(unique=true)
    String reasonForRecall;
}
