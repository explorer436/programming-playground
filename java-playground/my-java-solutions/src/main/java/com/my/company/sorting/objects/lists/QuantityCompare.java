package com.my.company.sorting.objects.lists;

import java.util.Comparator;

import com.my.company.sorting.objects.Fruit;

public class QuantityCompare implements Comparator<Fruit>{

	public int compare(Fruit f1, Fruit f2) {
		if (f1.getQuantity() < f2.getQuantity())
			return -1;
		if (f1.getQuantity() > f2.getQuantity())
			return 1;
		else
			return 0;
	}

}
