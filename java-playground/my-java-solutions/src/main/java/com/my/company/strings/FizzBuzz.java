package com.my.company.strings;

import java.util.LinkedList;
import java.util.List;

/**
 * Write a program that outputs the string representation of numbers from 1 to n.
 *
 * <p>But for multiples of three it should output “Fizz” instead of the number and for the multiples
 * of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.
 *
 * <p>Example:
 *
 * <p>n = 15,
 *
 * <p>Return: [ "1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13",
 * "14", "FizzBuzz" ]
 */
public class FizzBuzz {

    public List<String> fizzBuzz(int n) {

        List<String> result = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                result.add("FizzBuzz");
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(String.valueOf(i));
            }
        }

        return result;
    }
}
