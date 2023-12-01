package com.my.company;

import com.my.company.collections.Person;

import java.util.ArrayList;
import java.util.List;

public class TestsHelper {

    public static List<Person> getPeople() {
        List<Person> people = new ArrayList<Person>();
        people.add(Person.builder().id(1).name("John").age(15).gender("male").addressLine1("123 JohnJane Ln").city("Dover").state("NH").zip("03820").build());
        people.add(Person.builder().id(2).name("Rob").age(25).gender("male").addressLine1("123 RobGayle Ln").city("Dover").state("NH").zip("03820").build());
        people.add(Person.builder().id(3).name("Clark").age(35).gender("male").addressLine1("123 ClarkMary Ln").city("Dover").state("NH").zip("03820").build());
        people.add(Person.builder().id(4).name("Trevor").age(45).gender("male").addressLine1("123 TrevorSophie Ln").city("Dover").state("NH").zip("03820").build());
        people.add(Person.builder().id(5).name("Jane").age(15).gender("female").addressLine1("123 JohnJane Ln").city("Dover").state("NH").zip("03820").build());
        people.add(Person.builder().id(6).name("Gayle").age(25).gender("female").addressLine1("123 RobGayle Ln").city("Dover").state("NH").zip("03820").build());
        people.add(Person.builder().id(7).name("Mary").age(35).gender("female").addressLine1("123 ClarkMary Ln").city("Dover").state("NH").zip("03820").build());
        people.add(Person.builder().id(8).name("Sophie").age(45).gender("female").addressLine1("123 TrevorSophie Ln").city("Dover").state("NH").zip("03820").build());
        people.add(Person.builder().id(8).name("Sophie").age(45).gender("female").addressLine1("123 TrevorSophie Ln").city("Dover").state("NH").zip("03820").build());
        return people;
    }

}
