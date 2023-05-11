package com.my.company.numbers;

import java.util.Arrays;
import java.util.List;

public class GCDOfNumbersInAnArray {

    public static void main(String[] args) {

        int[] nums = new int[]{16, 32, 96};

        System.out.println(
                "Sum of all elements of the array "
                        + Arrays.toString(nums)
                        + " calculated using stream reduce is "
                        + getSum(nums));

        System.out.println(
                "GCD of all elements of the array "
                        + Arrays.toString(nums)
                        + " calculated using stream reduce is "
                        + getGcd(nums));
    }

    public static int getGcd(List<Integer> inputList) {
        Integer gcdOfAllElementsOfAnArrayCalculatedUsingStreamReduce =
                inputList.stream().reduce(0, (a, b) -> GCDOfTwoNumbersUsingEuclideanAlgorithm.gcd(a, b));

        return gcdOfAllElementsOfAnArrayCalculatedUsingStreamReduce;
    }

    public static int getGcd(int[] A) {
        Integer gcdOfAllElementsOfAnArrayCalculatedUsingStreamReduce =
                Arrays.stream(A).reduce(0, (a, b) -> GCDOfTwoNumbersUsingEuclideanAlgorithm.gcd(a, b));

        return gcdOfAllElementsOfAnArrayCalculatedUsingStreamReduce;
    }

    /**
     * This is just an example. This is not exactly used in this class - it is pasted for reference.
     */
    public static int getSum(int[] A) {
        Integer totalSumCalculatedUsingStreamReduce = Arrays.stream(A).reduce(0, (a, b) -> a + b);

        return totalSumCalculatedUsingStreamReduce;
    }
}
