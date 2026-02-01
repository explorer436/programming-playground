package com.my.company.numbers;

import java.util.Arrays;
import java.util.List;

public class GCDOfNumbersInAnArray {

    public int getGcdOfNumbersInAList(List<Integer> inputList) {
        GCDOfTwoNumbersUsingEuclideanAlgorithm gcd = new GCDOfTwoNumbersUsingEuclideanAlgorithm();

        return inputList.stream().reduce(0, gcd::gcd);
    }

    public int getGcdOfNumbersInAnArray(int[] A) {
        GCDOfTwoNumbersUsingEuclideanAlgorithm gcd = new GCDOfTwoNumbersUsingEuclideanAlgorithm();

        return Arrays.stream(A).reduce(0, gcd::gcd);
    }

}
