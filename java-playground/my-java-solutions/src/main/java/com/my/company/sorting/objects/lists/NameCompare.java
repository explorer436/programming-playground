package com.my.company.sorting.objects.lists;

import java.util.Comparator;

import com.my.company.sorting.objects.Fruit;

//Class to compare Fruits by name
public class NameCompare implements Comparator<Fruit> {
	public int compare(Fruit f1, Fruit f2) {
		String fruitName1 = f1.getFruitName().toUpperCase();
		String fruitName2 = f2.getFruitName().toUpperCase();

		// ascending order
		return fruitName1.compareTo(fruitName2);

		// descending order
		// return fruitName2.compareTo(fruitName1);
	}
}