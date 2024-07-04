package com.my.company.datastructures.streamsapi;

import java.util.List;

public class StreamAPI {

  /** Aggregate Operations */
  public static void printTheNameOfEachPerson_AggregateOperations(List<Person> people) {
    System.out.println("using a for each loop");
    for (Person p : people) {
      System.out.println(p.getName());
    }

    System.out.println("using the aggregate operation forEach");
    people.stream().forEach(e -> System.out.println(e.getName()));
  }

  /** Pipeline Operations */
  public static void printNamesOfMen_Pipelines(List<Person> people) {
    people.stream()
        .filter(e -> e.getGender().equals("male"))
        .forEach(e -> System.out.println(e.getName()));
  }

  /** Reduction Operations */
  public static double getAverageAgeOfMen_TerminalOperator(List<Person> people) {
    double average =
        people.stream()
            .filter(p -> p.getGender().equals("male"))
            .mapToInt(Person::getAge)
            .average()
            .getAsDouble();
    return average;
  }
}
