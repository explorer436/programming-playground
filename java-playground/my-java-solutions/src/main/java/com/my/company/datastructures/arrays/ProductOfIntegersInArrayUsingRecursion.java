package com.my.company.datastructures.arrays;

import java.util.Arrays;

/**
 * Write a recursive function that computes and returns the product of the integer in the array
 * anArray[ﬁrst..last].
 */
public class ProductOfIntegersInArrayUsingRecursion {
  public static void main(String[] args) {

    Integer[] anArray;

    anArray = new Integer[] {5, 2, 10};
    System.out.println(
        "productOfElements_recursion of anArray : "
            + ProductOfIntegersInArrayUsingRecursion.productOfElements_recursion(anArray));

    anArray = new Integer[] {5};
    System.out.println(
        "productOfElements_recursion of anArray : "
            + ProductOfIntegersInArrayUsingRecursion.productOfElements_recursion(anArray));

    anArray = new Integer[] {};
    System.out.println(
        "productOfElements_recursion of anArray : "
            + ProductOfIntegersInArrayUsingRecursion.productOfElements_recursion(anArray));

    anArray = new Integer[] {5, 2, 10, 0};
    System.out.println(
        "productOfElements_recursion of anArray : "
            + ProductOfIntegersInArrayUsingRecursion.productOfElements_recursion(anArray));

    System.out.println();

    anArray = new Integer[] {5, 2, 10};
    System.out.println(
        "productOfElements_iteration of anArray : "
            + ProductOfIntegersInArrayUsingRecursion.productOfElements_iteration(anArray));

    anArray = new Integer[] {5};
    System.out.println(
        "productOfElements_iteration of anArray : "
            + ProductOfIntegersInArrayUsingRecursion.productOfElements_iteration(anArray));

    anArray = new Integer[] {};
    System.out.println(
        "productOfElements_iteration of anArray : "
            + ProductOfIntegersInArrayUsingRecursion.productOfElements_iteration(anArray));

    anArray = new Integer[] {5, 2, 10, 0};
    System.out.println(
        "productOfElements_iteration of anArray : "
            + ProductOfIntegersInArrayUsingRecursion.productOfElements_iteration(anArray));
  }

  public static int productOfElements_recursion(Integer[] anArray) {

    int result = 0;

    if (null != anArray && anArray.length != 0) {
      if (anArray.length == 1) {
        result = anArray[0];
      } else {
        result =
            anArray[0]
                * productOfElements_recursion(Arrays.copyOfRange(anArray, 1, anArray.length));
      }
    }

    return result;
  }

  public static int productOfElements_iteration(Integer[] anArray) {

    int result = 0;

    if (null != anArray && anArray.length != 0) {
      result = 1;
      for (Integer i : anArray) {
        result = result * i;
      }
    }

    return result;
  }
}
