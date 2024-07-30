package com.my.company.sortingobjects;

import lombok.Getter;

@Getter
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

  public int compareTo(Fruit compareFruit) {
    int compareQuantity = ((Fruit) compareFruit).getQuantity();

    // ascending order
    return this.quantity - compareQuantity;

    // descending order
    // return compareQuantity - this.quantity;
  }
}
