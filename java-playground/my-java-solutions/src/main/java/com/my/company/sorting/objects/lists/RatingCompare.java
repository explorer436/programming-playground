package com.my.company.sorting.objects.lists;

import java.util.Comparator;

import com.my.company.sorting.objects.Fruit;

// Class to compare Fruits by ratiing
public class RatingCompare implements Comparator<Fruit> {
    public int compare(Fruit f1, Fruit f2) {
        if (f1.getRating() < f2.getRating()) return -1;
        if (f1.getRating() > f2.getRating()) return 1;
        else return 0;
    }
}
