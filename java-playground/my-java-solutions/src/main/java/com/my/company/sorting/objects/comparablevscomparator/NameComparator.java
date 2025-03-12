package com.my.company.sorting.objects.comparablevscomparator;

import java.util.Comparator;

// Class to compare Fruits by name
public class NameComparator implements Comparator<Fruit> {

  public int compare(Fruit f1, Fruit f2) {
    String fruitName1 = f1.getFruitName().toUpperCase();
    String fruitName2 = f2.getFruitName().toUpperCase();

    // ascending order
    return fruitName1.compareTo(fruitName2);

    // descending order
    // return fruitName2.compareTo(fruitName1);
  }

}
