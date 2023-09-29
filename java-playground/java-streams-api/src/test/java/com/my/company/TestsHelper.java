package com.my.company;

import com.my.company.collections.Person;

import java.util.ArrayList;
import java.util.List;

public class TestsHelper {

    public static List<Person> getPeople() {
        List<Person> people = new ArrayList<Person>();
        people.add(Person.builder().name("1John").age(15).gender("male").addressLine1("123 JohnJane Ln").city("Dover").state("NH").zip("03820").build());
        people.add(Person.builder().name("2Rob").age(25).gender("male").addressLine1("123 RobGayle Ln").city("Dover").state("NH").zip("03820").build());
        people.add(Person.builder().name("3Clark").age(35).gender("male").addressLine1("123 ClarkMary Ln").city("Dover").state("NH").zip("03820").build());
        people.add(Person.builder().name("4Trevor").age(45).gender("male").addressLine1("123 TrevorSophie Ln").city("Dover").state("NH").zip("03820").build());
        people.add(Person.builder().name("5Jane").age(15).gender("female").addressLine1("123 JohnJane Ln").city("Dover").state("NH").zip("03820").build());
        people.add(Person.builder().name("6Gayle").age(25).gender("female").addressLine1("123 RobGayle Ln").city("Dover").state("NH").zip("03820").build());
        people.add(Person.builder().name("7Mary").age(35).gender("female").addressLine1("123 ClarkMary Ln").city("Dover").state("NH").zip("03820").build());
        people.add(Person.builder().name("8Sophie").age(45).gender("female").addressLine1("123 TrevorSophie Ln").city("Dover").state("NH").zip("03820").build());
        return people;
    }

}
