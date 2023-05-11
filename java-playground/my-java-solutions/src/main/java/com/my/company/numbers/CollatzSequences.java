package com.my.company.numbers;

/**
 * Collatz sequences : We take a natural number. If that number is even, we divide it by two. If
 * it's odd, we multiply it by 3 and then add 1 to that. We take the resulting number and apply the
 * same thing to it, which produces a new number and so on. In essence, we get a chain of numbers.
 * It is thought that for all starting numbers, the chains finish at the number 1.
 *
 * <p>So if we take the starting number 13, we get this sequence: 13, 40, 20, 10, 5, 16, 8, 4, 2, 1.
 * 13*3 + 1 equals 40. 40 divided by 2 is 20, etc. We see that the chain has 10 terms.
 *
 * <p>Now what we want to know is this: for all starting numbers between 1 and 100, how many chains
 * have a length greater than 15?
 *
 * <p>ghci> chain 10 [10,5,16,8,4,2,1] ghci> chain 1 [1] ghci> chain 30
 * [30,15,46,23,70,35,106,53,160,80,40,20,10,5,16,8,4,2,1]
 */
public class CollatzSequences {

    public static void main(String[] args) throws Exception {

        int result;

        result = getCollatzSequenceLength(13);
        if (10 != result) {
            throw new Exception("wrong answer - expected " + "10" + " but received " + result);
        }

        result = getCollatzSequenceLength(30);
        if (19 != result) {
            throw new Exception("wrong answer - expected " + "19" + " but received " + result);
        }

        System.out.println(
                "countOfIntegersForWhichChainLengthIsGreaterThan15 : "
                        + countOfIntegersForWhichChainLengthIsGreaterThan15());

        printCollatzSequence(13);

        System.out.println("done");
    }

    private static int countOfIntegersForWhichChainLengthIsGreaterThan15() {
        int result = 0;

        for (int i = 1; i <= 100; i++) {
            if (getCollatzSequenceLength(i) > 15) {
                result = result + 1;
            }
        }

        return result;
    }

    private static int getCollatzSequenceLength(int number) {
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

    private static void printCollatzSequence(int number) {
        System.out.println(">>> printing Collatz sequence for the number : " + number);
        if (number <= 0) {
            System.out.println("Input is invalid.");
        } else {
            System.out.print(number);
            while (number > 1) {
                System.out.print(" - ");
                if (number % 2 == 0) {
                    number = number / 2;
                } else {
                    number = (number * 3) + 1;
                }
                System.out.print(number);
            }
        }

        System.out.println("");
    }
}
