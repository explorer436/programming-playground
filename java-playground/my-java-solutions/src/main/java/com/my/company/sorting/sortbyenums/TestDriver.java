package com.my.company.sorting.sortbyenums;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TestDriver {
  public static void main(String[] args) {
    System.out.println("Hello World!");

    Person p1 = Person.builder().name("A B").personRole(PersonRole.PARENT).build();
    Person p2 = Person.builder().name("C D").personRole(PersonRole.GRANDPARENT).build();
    Person p3 = Person.builder().name("E F").personRole(PersonRole.CHILD).build();

    List<Person> unsortedPersonsList = Arrays.asList(p1, p2, p3);

    System.out.println("unsorted");
    unsortedPersonsList.forEach(p -> System.out.println(p.toString()));

    List<Person> sortedPersonsList =
        unsortedPersonsList
                .stream()
                .sorted(myComparator())
                .collect(Collectors.toList());

    System.out.println("------------");
    System.out.println("sorted");
    sortedPersonsList.forEach(p -> System.out.println(p.toString()));
  }

  private static Comparator<Person> myComparator() {
    return Comparator.comparing(p -> p.getPersonRole().getHierarchy());
  }
}
