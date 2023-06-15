/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.beersapi.repositories;

import com.example.beersapi.entities.Beer;
import java.util.stream.Stream;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BeerCommandLineRunner implements
        CommandLineRunner {

    private final BeerRepository repository;

    public BeerCommandLineRunner(BeerRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) throws
            Exception {
        // Top beers from https://www.beeradvocate.com/lists/top/
        Stream.of("Kentucky Brunch Brand Stout",
                "Good Morning", "Very Hazy", "King Julius",
                "Budweiser", "Coors Light",
                "PBR").forEach(name
                        -> repository.save(new Beer(name))
                );
        repository.findAll().forEach(System.out::println);
    }
}
