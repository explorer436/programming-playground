package com.my.company.sortingobjects;

import java.util.Comparator;

public class Fruit implements Comparable<Fruit> {

    private String fruitName;
    private String fruitDesc;
    private int quantity;
    private int rating;

    public Fruit(String fruitName, String fruitDesc, int quantity, int rating) {
        super();
        this.fruitName = fruitName;
        this.fruitDesc = fruitDesc;
        this.quantity = quantity;
        this.rating = rating;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public String getFruitDesc() {
        return fruitDesc;
    }

    public void setFruitDesc(String fruitDesc) {
        this.fruitDesc = fruitDesc;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int compareTo(Fruit compareFruit) {
        int compareQuantity = ((Fruit) compareFruit).getQuantity();

        // ascending order
        return this.quantity - compareQuantity;

        // descending order
        // return compareQuantity - this.quantity;
    }

    public static final Comparator<Fruit> FruitNameComparator =
            new Comparator<Fruit>() {
                public int compare(Fruit fruit1, Fruit fruit2) {
                    String fruitName1 = fruit1.getFruitName().toUpperCase();
                    String fruitName2 = fruit2.getFruitName().toUpperCase();

                    // ascending order
                    return fruitName1.compareTo(fruitName2);

                    // descending order
                    // return fruitName2.compareTo(fruitName1);
                }
            };

    public static final Comparator<Fruit> RatingComparator =
            new Comparator<Fruit>() {
                public int compare(Fruit fruit1, Fruit fruit2) {
                    int fruitRating1 = fruit1.getRating();
                    int fruitRating2 = fruit2.getRating();

                    // ascending order
                    if (fruitRating1 < fruitRating2) return -1;
                    if (fruitRating1 > fruitRating2) return 1;
                    else return 0;
                    // return fruitRating1.compareTo(fruitRating2);

                    // descending order
                    // return fruitName2.compareTo(fruitName1);
                }
            };
}
