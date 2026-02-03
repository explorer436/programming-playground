package com.my.company.numbers;

class SumOfEvenFibonacciNumbersBelowN {

    static int sumOfEvenFibonacciNumbersBelowN(int limit) {
        if (limit < 2)
            return 0;

        // Initialize first two even Fibonacci numbers
        // and their sum
        long ef1 = 0, ef2 = 2;
        long sum = ef1 + ef2;

        // calculating sum of even Fibonacci value
        while (ef2 <= limit) {
            // get next even value of Fibonacci sequence
            long ef3 = 4 * ef2 + ef1;

            // If we go beyond limit, we break loop
            if (ef3 > limit)
                break;

            // Move to next even number and update sum
            ef1 = ef2;
            ef2 = ef3;
            sum += ef2;
        }

        return (int) sum;
    }
}