package com.my.company.fractions;

public class CalculateFractionsOfPositiveNegativeAndZeroElementsInAnArray {

    public static void main(String[] args) {
        plusMinus(new int[]{-4, 3, -9, 0, 4, 1});
    }

    static void plusMinus(int[] arr) {

        float negativeNumbersCount = 0;
        float positiveNumbersCount = 0;
        float zeroesCount = 0;

        for (int i : arr) {
            if (i < 0) {
                negativeNumbersCount++;
            } else if (i > 0) {
                positiveNumbersCount++;
            } else {
                zeroesCount++;
            }
        }

        System.out.println("negativeNumbersCount : " + negativeNumbersCount);
        System.out.println("positiveNumbersCount : " + positiveNumbersCount);
        System.out.println("zeroesCount : " + zeroesCount);

        // Format Float to n decimal places
        System.out.println(String.format("%.6f", positiveNumbersCount / arr.length));
        System.out.println(String.format("%.6f", negativeNumbersCount / arr.length));
        System.out.println(String.format("%.6f", zeroesCount / arr.length));
    }
}
