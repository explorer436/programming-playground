package com.my.company.datastructures.streamsapi;

import com.my.company.datastructures.streamsapi.model.Person;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class AggregateOperations {

  public static void main(String[] args) {
    printTheNameOfEachPerson_AggregateOperations(TestsHelper.getPeople());
  }

  public static void printTheNameOfEachPerson_AggregateOperations(List<Person> people) {
    log.info("using a for each loop");
    for (Person p : people) {
      log.info(p.getName());
    }

    log.info("using the aggregate operation forEach");
    people.stream()
            .forEach(e -> log.info(e.getName()));
  }
}
