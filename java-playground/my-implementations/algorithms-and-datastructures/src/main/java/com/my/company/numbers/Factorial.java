package com.my.company.numbers;

public class Factorial {

  public int factorial_recursive(int number) {
    int result = 0;

    if (number < 0) {
      return 0;
    }
    if (1 == number || 0 == number) {
      return 1;
    } else {
      result = number * factorial_recursive(number - 1);
    }

    return result;
  }

  public int factorial_iteration(int number) {

    // factorial(0) = 1
    int previous = 1;

    // factorial(1) = 1
    // int current = 1;
    if (1 == number || 0 == number) {
      return 1;
    } else {
      int result = 0;
      for (int i = 2; i <= number; i++) {
        result = i * (previous);

        previous = result;
      }
      return result;
    }
  }
}
