package com.my.company.sortingobjects;

import java.util.Comparator;

// Class to compare Fruits by rating and name simultaneously.
// This comparator doesn't have to be in the client class.
// This method can be written in the class Fruit.
public class RatingAndNameComparator implements Comparator<Fruit> {

  public int compare(Fruit f1, Fruit f2) {
    // sort the fruits by rating first.
    int ratingComparisonResult = 0;
    if (f1.getRating() < f2.getRating()) {
      ratingComparisonResult = -1;
    } else if (f1.getRating() > f2.getRating()) {
      ratingComparisonResult = 1;
    } else {
      // sort the fruits by name.
      String fruitName1 = f1.getFruitName().toUpperCase();
      String fruitName2 = f2.getFruitName().toUpperCase();

      // ascending order
      if (fruitName1.compareTo(fruitName2) > 0) {
        ratingComparisonResult = 1;
      } else if (fruitName1.compareTo(fruitName2) < 0) {
        ratingComparisonResult = -1;
      } else {
        ratingComparisonResult = 0;
      }
    }
    return ratingComparisonResult;
  }
}
