package com.my.company.sorting.objects.comparablevscomparator;

import java.util.Comparator;

public class QuantityComparator implements Comparator<Fruit> {

  public int compare(Fruit f1, Fruit f2) {
    if (f1.getQuantity() < f2.getQuantity()) return -1;
    if (f1.getQuantity() > f2.getQuantity()) return 1;
    else return 0;
  }
}
