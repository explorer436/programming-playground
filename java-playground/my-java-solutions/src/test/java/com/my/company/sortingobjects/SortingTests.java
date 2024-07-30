package com.my.company.sortingobjects;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortingTests {

    Fruit pineappale = new Fruit("Pineapple", "Pineapple description", 60, 4);
    Fruit apple = new Fruit("Apple", "Apple description", 100, 1);
    Fruit orange = new Fruit("Orange", "Orange description", 70, 2);
    Fruit banana = new Fruit("Banana", "Banana description", 90, 3);
    Fruit cranberry = new Fruit("Cranberry", "Cranberry description", 80, 5);
    Fruit blueberry = new Fruit("Blueberry", "Blueberry description", 50, 5);

    @Test
    public void test_Comparable_compareTo_on_arrays() throws Exception {

        Fruit[] fruitsArray = getFruitsArray();

        // Before sorting
        assertEquals(pineappale, fruitsArray[0]);
        assertEquals(apple, fruitsArray[1]);
        assertEquals(orange, fruitsArray[2]);
        assertEquals(banana, fruitsArray[3]);
        assertEquals(cranberry, fruitsArray[4]);
        assertEquals(blueberry, fruitsArray[5]);

        Arrays.sort(fruitsArray);

        // sorted in the ascending order based on "quantity" because the compareTo() is using quantity
        assertEquals(blueberry, fruitsArray[0]);
        assertEquals(pineappale, fruitsArray[1]);
        assertEquals(orange, fruitsArray[2]);
        assertEquals(cranberry, fruitsArray[3]);
        assertEquals(banana, fruitsArray[4]);
        assertEquals(apple, fruitsArray[5]);
    }

    @Test
    public void test_Comparator_byName_on_arrays() throws Exception {

        Fruit[] fruitsArray = getFruitsArray();

        // Before sorting
        assertEquals(pineappale, fruitsArray[0]);
        assertEquals(apple, fruitsArray[1]);
        assertEquals(orange, fruitsArray[2]);
        assertEquals(banana, fruitsArray[3]);
        assertEquals(cranberry, fruitsArray[4]);
        assertEquals(blueberry, fruitsArray[5]);

        Arrays.sort(fruitsArray, new NameComparator());

        assertEquals(apple, fruitsArray[0]);
        assertEquals(banana, fruitsArray[1]);
        assertEquals(blueberry, fruitsArray[2]);
        assertEquals(cranberry, fruitsArray[3]);
        assertEquals(orange, fruitsArray[4]);
        assertEquals(pineappale, fruitsArray[5]);
    }

    @Test
    public void test_Comparable_compareTo_on_lists() throws Exception {

        List<Fruit> fruitsList = getFruitsList();

        // Before sorting
        assertEquals(pineappale, fruitsList.get(0));
        assertEquals(apple, fruitsList.get(1));
        assertEquals(orange, fruitsList.get(2));
        assertEquals(banana, fruitsList.get(3));
        assertEquals(cranberry, fruitsList.get(4));
        assertEquals(blueberry, fruitsList.get(5));

        Collections.sort(fruitsList);

        // sorted in the ascending order based on "quantity" because the compareTo() is using quantity
        assertEquals(blueberry, fruitsList.get(0));
        assertEquals(pineappale, fruitsList.get(1));
        assertEquals(orange, fruitsList.get(2));
        assertEquals(cranberry, fruitsList.get(3));
        assertEquals(banana, fruitsList.get(4));
        assertEquals(apple, fruitsList.get(5));
    }

    @Test
    public void test_Comparable_compareTo_in_reverse_order_on_lists() throws Exception {

        List<Fruit> fruitsList = getFruitsList();

        // Before sorting
        assertEquals(pineappale, fruitsList.get(0));
        assertEquals(apple, fruitsList.get(1));
        assertEquals(orange, fruitsList.get(2));
        assertEquals(banana, fruitsList.get(3));
        assertEquals(cranberry, fruitsList.get(4));
        assertEquals(blueberry, fruitsList.get(5));

        Collections.sort(fruitsList, Collections.reverseOrder());

        // sorted in the descending order based on "quantity" because the compareTo() is using quantity
        assertEquals(blueberry, fruitsList.get(5));
        assertEquals(pineappale, fruitsList.get(4));
        assertEquals(orange, fruitsList.get(3));
        assertEquals(cranberry, fruitsList.get(2));
        assertEquals(banana, fruitsList.get(1));
        assertEquals(apple, fruitsList.get(0));
    }

    @Test
    public void test_Comparator_byName_on_lists() throws Exception {

        List<Fruit> fruitsList = getFruitsList();

        // Before sorting
        assertEquals(pineappale, fruitsList.get(0));
        assertEquals(apple, fruitsList.get(1));
        assertEquals(orange, fruitsList.get(2));
        assertEquals(banana, fruitsList.get(3));
        assertEquals(cranberry, fruitsList.get(4));
        assertEquals(blueberry, fruitsList.get(5));

        Collections.sort(fruitsList, new NameComparator());

        assertEquals(apple, fruitsList.get(0));
        assertEquals(banana, fruitsList.get(1));
        assertEquals(blueberry, fruitsList.get(2));
        assertEquals(cranberry, fruitsList.get(3));
        assertEquals(orange, fruitsList.get(4));
        assertEquals(pineappale, fruitsList.get(5));
    }

    @Test
    public void test_Comparator_byRating_on_lists() throws Exception {

        List<Fruit> fruitsList = getFruitsList();

        // Before sorting
        assertEquals(pineappale, fruitsList.get(0));
        assertEquals(apple, fruitsList.get(1));
        assertEquals(orange, fruitsList.get(2));
        assertEquals(banana, fruitsList.get(3));
        assertEquals(cranberry, fruitsList.get(4));
        assertEquals(blueberry, fruitsList.get(5));

        Collections.sort(fruitsList, new RatingComparator());

        assertEquals(apple, fruitsList.get(0));
        assertEquals(orange, fruitsList.get(1));
        assertEquals(banana, fruitsList.get(2));
        assertEquals(pineappale, fruitsList.get(3));
        assertEquals(cranberry, fruitsList.get(4));
        assertEquals(blueberry, fruitsList.get(5));
    }

    @Test
    public void test_Comparator_byQuantity_on_lists() throws Exception {

        List<Fruit> fruitsList = getFruitsList();

        // Before sorting
        assertEquals(pineappale, fruitsList.get(0));
        assertEquals(apple, fruitsList.get(1));
        assertEquals(orange, fruitsList.get(2));
        assertEquals(banana, fruitsList.get(3));
        assertEquals(cranberry, fruitsList.get(4));
        assertEquals(blueberry, fruitsList.get(5));

        Collections.sort(fruitsList, new QuantityComparator());

        assertEquals(blueberry, fruitsList.get(0));
        assertEquals(pineappale, fruitsList.get(1));
        assertEquals(orange, fruitsList.get(2));
        assertEquals(cranberry, fruitsList.get(3));
        assertEquals(banana, fruitsList.get(4));
        assertEquals(apple, fruitsList.get(5));
    }

    @Test
    public void test_Comparator_byRatingAndName_on_lists() throws Exception {

        List<Fruit> fruitsList = getFruitsList();

        // Before sorting
        assertEquals(pineappale, fruitsList.get(0));
        assertEquals(apple, fruitsList.get(1));
        assertEquals(orange, fruitsList.get(2));
        assertEquals(banana, fruitsList.get(3));
        assertEquals(cranberry, fruitsList.get(4));
        assertEquals(blueberry, fruitsList.get(5));

        Collections.sort(fruitsList, new RatingAndNameComparator());

        assertEquals(apple, fruitsList.get(0));
        assertEquals(orange, fruitsList.get(1));
        assertEquals(banana, fruitsList.get(2));
        assertEquals(pineappale, fruitsList.get(3));
        assertEquals(blueberry, fruitsList.get(4));
        assertEquals(cranberry, fruitsList.get(5));
    }

    private Fruit[] getFruitsArray() {
        Fruit[] fruitsArray = new Fruit[6];
        fruitsArray[0] = pineappale;
        fruitsArray[1] = apple;
        fruitsArray[2] = orange;
        fruitsArray[3] = banana;
        fruitsArray[4] = cranberry;
        fruitsArray[5] = blueberry;
        return fruitsArray;
    }

    private List<Fruit> getFruitsList() {
        return Arrays.asList(getFruitsArray());
    }
}
