package com.my.company.recursion;

public class TowersOfHanoi {
  public static void main(String[] args) {
    solveTowers(3, "A", "B", "C");
  }

  /*
   * A - source
   * B - destination
   * C - spare
   */
  public static void solveTowers(int count, String source, String destination, String spare) {
    if (count == 1) {
      System.out.println("The top disc is moved from pole " + source + " to pole " + destination);
    } else {
      solveTowers(count - 1, source, spare, destination);      solveTowers(1, source, destination, spare);
      solveTowers(count - 1, spare, destination, source);
    }
  }
}
