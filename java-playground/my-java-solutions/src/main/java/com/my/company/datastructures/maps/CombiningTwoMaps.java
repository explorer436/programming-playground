package com.my.company.datastructures.maps;

import com.my.company.streamsapi.TestsHelper;
import com.my.company.streamsapi.model.Person;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
public class CombiningTwoMaps {
    public static void main(String[] args) {

        List<Person> people = TestsHelper.getPeople();

        Map<String, List<Person>> existingMap = people.stream().collect(Collectors.groupingBy(Person::getGender));

        log.info("{}",existingMap.get("female").size()); // 5
        log.info("{}",existingMap.get("male").size()); // 4

        List<Person> peopleFromAnotherCountry = getPeopleFromAnotherCountry();


        // Approach 1
        // Build a new map
        Map<String, List<Person>> peopleByGenderMap2 = peopleFromAnotherCountry.stream().collect(Collectors.groupingBy(Person::getGender));
        // Iterate over the entryset of the new map
        peopleByGenderMap2.entrySet().stream()
                .forEach(input -> existingMap.get(input.getKey()).addAll(input.getValue()));
        log.info("{}",existingMap.get("female").size()); // 6
        log.info("{}",existingMap.get("male").size()); // 5


        // Approach 2 - use a for loop on the new list and add them to the existing map.
        peopleFromAnotherCountry.stream()
                .forEach(p -> existingMap.get(p.getGender()).add(p));
        log.info("{}",existingMap.get("female").size()); // 6
        log.info("{}",existingMap.get("male").size()); // 5
    }

    public static List<Person> getPeopleFromAnotherCountry() {
        List<Person> people = new ArrayList<Person>();
        people.add(Person.builder().id(2).firstname("Ajay").lastname("Kumar").age(25).gender("male").addressLine1("123 RobGayle Ln").city("Dover").state("NH").zip("03820").phones(Arrays.asList("555-2243", "555-5264")).build());
        people.add(Person.builder().id(5).firstname("Radha").lastname("Lakshmi").age(15).gender("female").addressLine1("123 JohnJane Ln").city("Dover").state("NH").zip("03820").build());
        return people;
    }
}
