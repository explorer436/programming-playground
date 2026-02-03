package com.my.company.numbers;

public class SumOfAllOddSquaresSmallerThanN {

    public static double getSumOfAllOddSquaresSmallerThanN(int n) {
        double result = 0;

        for (int i = 1; i < n; i++) {
            if (i % 2 != 0) {
                result = result + (Math.pow(i, 2));
            }
        }

        System.out.printf("result : " + result);

        System.out.println();

        // How to print a double value without scientific notation in Java?

        System.out.printf("result: %f\n", result);

        return result;
    }
}
