package com.my.company.numbers;

import java.util.ArrayList;
import java.util.List;

public class CollatzSequences {

    public int countOfIntegersForWhichChainLengthIsGreaterThan15(int lower, int upper) {
        int result = 0;

        for (int i = lower; i <= upper; i++) {
            if (getCollatzSequenceLength(i) > 15) {
                result = result + 1;
            }
        }

        return result;
    }

    public int getCollatzSequenceLength(int number) {
        int chainLength = 1;

        while (number > 1) {
            chainLength = chainLength + 1;
            if (number % 2 == 0) {
                number = number / 2;
            } else {
                number = (number * 3) + 1;
            }
        }

        return chainLength;
    }

    public List<Integer> getCollatzSequence(int number) {

        System.out.println(">>> printing Collatz sequence for the number : " + number);
        if (number <= 0) {
            return null;
        }

        List<Integer> result = new ArrayList<>();
        result.add(number);
        while (number > 1) {
            if (number % 2 == 0) {
                result.add(number / 2);
                number = number / 2;
            } else {
                result.add(number * 3 + 1);
                number = (number * 3) + 1;
            }
        }

        return result;
    }
}
