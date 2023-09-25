package com.my.company.sortingobjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * Suppose we want sort fruits by their name and quantity also (RatingAndNameCompare).
 * When we make a collection element comparable(by having it implement Comparable),
 * we get only one chance to implement the compareTo() method.
 * The solution is using Comparator.
 */
public class ArraysAndListsComparator {

    public static void main(String[] args) {
        System.out.println(" --- comparators and sorting on arrays --- ");

        Fruit pineappale = new Fruit("Pineapple", "Pineapple description", 60, 4);
        Fruit apple = new Fruit("Apple", "Apple description", 100, 1);
        Fruit orange = new Fruit("Orange", "Orange description", 70, 2);
        Fruit banana = new Fruit("Banana", "Banana description", 90, 3);
        Fruit cranberry = new Fruit("Cranberry", "Cranberry description", 80, 5);
        Fruit blueberry = new Fruit("Blueberry", "Blueberry description", 50, 5);

        Fruit[] fruitsArray = new Fruit[6];
        fruitsArray[0] = pineappale;
        fruitsArray[1] = apple;
        fruitsArray[2] = orange;
        fruitsArray[3] = banana;
        fruitsArray[4] = cranberry;
        fruitsArray[5] = blueberry;

        System.out.println("call sort");
        // Why is this sorting by quantity?
        // Instead of using any other parameter?
        // This is because the compareTo() in Fruit is using quantity
        Arrays.sort(fruitsArray);
        for (Fruit f : fruitsArray) {
            printFruit(f);
        }

        // If you don't want to use the default comparison method provided in the class's compareTo(),
        // write a custom comparator.
        System.out.println("using the name of the comparator");
        Arrays.sort(fruitsArray, Fruit.FruitNameComparator);
        for (Fruit f : fruitsArray) {
            printFruit(f);
        }

        System.out.println(" --- comparators and sorting on lists --- ");

        List<Fruit> fruitsList = new ArrayList<Fruit>();
        fruitsList.add(pineappale);
        fruitsList.add(apple);
        fruitsList.add(orange);
        fruitsList.add(banana);
        fruitsList.add(cranberry);
        fruitsList.add(blueberry);

        System.out.println("sorting the list");
        Collections.sort(fruitsList);
        // Why is this sorting by quantity?
        // Instead of using any other parameter?
        // This is because the compareTo() in Fruit is using quantity
        for (Fruit f : fruitsList) {
            printFruit(f);
        }

        System.out.println("sorting the list in reverse order");
        Collections.sort(fruitsList, Collections.reverseOrder());
        for (Fruit f : fruitsList) {
            printFruit(f);
        }

        System.out.println("sorting the list by name using comparator");
        Collections.sort(fruitsList, new NameComparator());
        for (Fruit f : fruitsList) {
            printFruit(f);
        }

        System.out.println("sorting the list by rating using comparator");
        Collections.sort(fruitsList, Fruit.RatingComparator);
        for (Fruit f : fruitsList) {
            printFruit(f);
        }

        System.out.println("sorting the list by quantity using comparator");
        Collections.sort(fruitsList, new QuantityComparator());
        for (Fruit f : fruitsList) {
            printFruit(f);
        }

        System.out.println("sorting the list by rating and name simultaneously");
        Collections.sort(fruitsList, new RatingAndNameComparator());
        for (Fruit f : fruitsList) {
            printFruit(f);
        }
    }

    public static void printFruit(Fruit f) {
        System.out.print("\t{");
        System.out.print("\"FruitName\":" + f.getFruitName() + ",");
        System.out.print("\"FruitDesc\":\"" + f.getFruitDesc() + "\",");
        System.out.print("\"Quantity\":" + f.getQuantity() + "\",");
        System.out.print("\"Rating\":" + f.getRating() + "\"}");
        System.out.print("\n");
    }
}
