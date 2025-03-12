package com.my.company.numbers;

import java.util.Arrays;

public class NextSmallestNumber {
    public int findNextSmallestNumber(int[] numbers, int number) {

        if (numbers == null) {
            return -1;
        }

        int len = numbers.length;

        if (len <= 0) {
            return -1;
        }

        if (number <= numbers[0]) {
            return -1;
        }

        if (number == numbers[len - 1]) {
            return numbers[len - 2];
        }

        if (number > numbers[len - 1]) {
            return numbers[len - 1];
        }

        int lower = 0;
        int mid = len / 2;

        if (numbers[mid] == number) {
            return number;
        }

        if (numbers[mid] < number) {
            if (number < numbers[mid + 1]) {
                return numbers[mid];
            }
            if (number == numbers[mid + 1]) {
                return numbers[mid];
            }
            lower = mid;
            return findNextSmallestNumber(Arrays.copyOfRange(numbers, lower, len), number);
        } else {
            if (number > numbers[mid + 1]) {
                return number;
            }
            lower = mid + 1;
            return findNextSmallestNumber(Arrays.copyOfRange(numbers, 0, lower), number);
        }


    }
}
