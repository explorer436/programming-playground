package com.my.company.strings;

import java.util.function.IntConsumer;

/**
 * Write a program that outputs the string representation of numbers from 1 to n, however:
 *
 * <p>If the number is divisible by 3, output "fizz". If the number is divisible by 5, output
 * "buzz". If the number is divisible by both 3 and 5, output "fizzbuzz".
 *
 * <p>For example, for n = 15, we output: 1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13,
 * 14, fizzbuzz.
 *
 * <p>Suppose you are given the following code:
 *
 * <p>class FizzBuzz { public FizzBuzz(int n) { ... } // constructor public void fizz(printFizz) {
 * ... } // only output "fizz" public void buzz(printBuzz) { ... } // only output "buzz" public void
 * fizzbuzz(printFizzBuzz) { ... } // only output "fizzbuzz" public void number(printNumber) { ... }
 * // only output the numbers }
 *
 * <p>Implement a multithreaded version of FizzBuzz with four threads. The same instance of FizzBuzz
 * will be passed to four different threads:
 *
 * <p>Thread A will call fizz() to check for divisibility of 3 and outputs fizz. Thread B will call
 * buzz() to check for divisibility of 5 and outputs buzz. Thread C will call fizzbuzz() to check
 * for divisibility of 3 and 5 and outputs fizzbuzz. Thread D will call number() which should only
 * output the numbers.
 */
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
