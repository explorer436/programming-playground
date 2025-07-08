package com.my.company.numbers;

public class LargestNumberUnderNDivisibleByAGivenNumber {

    public int getLargestNumberUnderNDivisibleByD(int N, int divisor) {

        if (N <= 0 || divisor <= 0) {
            return 0;
        }

        for (int i = N - 1; i > 0; i--) {
            if (i % divisor == 0) {
                return i;
            }
        }

        return 0;
    }
}
