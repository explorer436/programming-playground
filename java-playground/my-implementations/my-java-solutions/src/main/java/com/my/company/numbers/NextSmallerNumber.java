package com.my.company.numbers;

import java.util.Arrays;

public class NextSmallerNumber {

    public int findNextSmallerNumber(int[] numbers, int number) {

        if (numbers == null || numbers.length == 0) {
            return -1;
        }

        if (number <= numbers[0]) {
            return -1;
        }

        int len = numbers.length;

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
            return findNextSmallerNumber(Arrays.copyOfRange(numbers, lower, len), number);
        } else {
            if (number > numbers[mid + 1]) {
                return number;
            }
            lower = mid + 1;
            return findNextSmallerNumber(Arrays.copyOfRange(numbers, 0, lower), number);
        }


    }
}
