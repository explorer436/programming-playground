/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.beersapi.controller;

import com.example.beersapi.entities.Beer;
import com.example.beersapi.repositories.BeerRepository;
import java.util.Collection;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class BeerController {

    private final BeerRepository beerRepository;

    @GetMapping("/good-beers")
    public Collection<Beer> goodBeers() {
        return beerRepository.findAll().stream()
                .filter(this::isGreat)
                .collect(Collectors.toList());
    }

    private boolean isGreat(Beer beer) {
        return !beer.getName().equals("Budweiser")
                && !beer.getName().equals("Coors Light")
                && !beer.getName().equals("PBR");
    }

}
