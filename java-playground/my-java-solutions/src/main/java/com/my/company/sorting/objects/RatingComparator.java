package com.my.company.sorting.objects;

import java.util.Comparator;

// Class to compare Fruits by ratiing
public class RatingComparator implements Comparator<Fruit> {
  public int compare(Fruit f1, Fruit f2) {
    if (f1.getRating() < f2.getRating()) return -1;
    if (f1.getRating() > f2.getRating()) return 1;
    else return 0;
  }
}
