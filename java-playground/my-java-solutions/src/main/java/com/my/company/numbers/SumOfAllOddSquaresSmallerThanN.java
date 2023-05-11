package com.my.company.numbers;

/**
 * find the sum of all odd squares that are smaller than 10,000 expected : 166650
 */
public class SumOfAllOddSquaresSmallerThanN {

    public static void main(String[] args) {
        solution();
    }

    public static void solution() {
        double result = 0;

        for (int n = 1; n < 10000; n++) {
            if (n % 2 != 0) {
                result = result + (Math.pow(n, 2));
            }
        }

        System.out.printf("result : " + result);

        System.out.println();

        // How to print a double value without scientific notation in Java?

        System.out.printf("result: %f\n", result);
    }
}
