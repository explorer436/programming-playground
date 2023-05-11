package com.my.company.collections;

import java.util.Arrays;

public class StreamReduce {

    public static void main(String[] args) {
    }

    public static int getSumOfAllElementsOfArray(int[] A) {
        /*
         * boxed - Returns a Stream consisting of the elements of this stream, each
         * boxed to an Integer. This is an intermediate operation.
         */
        Integer sumOfAllElementsOfArray = Arrays.stream(A).boxed().reduce(0, (a, b) -> a + b);

        return sumOfAllElementsOfArray;
    }

    public static int getMaxElementInIntArray(int[] A) {
        return Arrays.stream(A).max().getAsInt();
    }

    public static int getMinElementInIntArray(int[] A) {
        return Arrays.stream(A).min().getAsInt();
    }

    public static int getProductOfAllElementsOfArray(int[] A) {
        Integer sumOfAllElementsOfArray = Arrays.stream(A).boxed().reduce(1, (a, b) -> a * b);

        return sumOfAllElementsOfArray;
    }
}
