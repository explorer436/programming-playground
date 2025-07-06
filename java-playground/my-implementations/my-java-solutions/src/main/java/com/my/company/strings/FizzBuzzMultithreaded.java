package com.my.company.strings;

import java.util.function.IntConsumer;

public class FizzBuzzMultithreaded {

  public static void main(String[] args) {

    // TODO

  }

  private int n;

  public FizzBuzzMultithreaded(int n) {
    this.n = n;
  }

  // printFizz.run() outputs "fizz".
  public void fizz(Runnable printFizz) throws InterruptedException {}

  // printBuzz.run() outputs "buzz".
  public void buzz(Runnable printBuzz) throws InterruptedException {}

  // printFizzBuzz.run() outputs "fizzbuzz".
  public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {}

  // printNumber.accept(x) outputs "x", where x is an integer.
  public void number(IntConsumer printNumber) throws InterruptedException {}
}
