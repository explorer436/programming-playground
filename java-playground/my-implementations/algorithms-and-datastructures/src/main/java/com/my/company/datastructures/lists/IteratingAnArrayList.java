package com.my.company.datastructures.lists;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class IteratingAnArrayList {

  static List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

  public static void main(String[] args) {

    /// Iterating ArrayList using Iterator
    Iterator<Integer> it = numbers.iterator();
    while (it.hasNext()) {
      System.out.printf("printing using iterator - %s %n", it.next());
    }
  }
}
