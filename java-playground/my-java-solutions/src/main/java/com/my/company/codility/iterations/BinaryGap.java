package com.my.company.codility.iterations;

/**
 * Level : Painless
 *
 * <p>Find longest sequence of zeros in binary representation of an integer.
 *
 * <p>A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is
 * surrounded by ones at both ends in the binary representation of N.
 *
 * <p>For example, number 9 has binary representation 1001 and contains a binary gap of length 2.
 * The number 529 has binary representation 1000010001 and contains two binary gaps: one of length 4
 * and one of length 3. The number 20 has binary representation 10100 and contains one binary gap of
 * length 1. The number 15 has binary representation 1111 and has no binary gaps. The number 32 has
 * binary representation 100000 and has no binary gaps.
 *
 * <p>Write a function:
 *
 * <p>class Solution { public int solution(int N); }
 *
 * <p>that, given a positive integer N, returns the length of its longest binary gap. The function
 * should return 0 if N doesn't contain a binary gap.
 *
 * <p>For example, given N = 1041 the function should return 5, because N has binary representation
 * 10000010001 and so its longest binary gap is of length 5. Given N = 32 the function should return
 * 0, because N has binary representation '100000' and thus no binary gaps.
 *
 * <p>Write an efficient algorithm for the following assumptions:
 *
 * <p>N is an integer within the range [1..2,147,483,647].
 */
public class BinaryGap {
    public static void main(String[] args) throws Exception {
        int finalResult;

        finalResult = (new BinaryGap()).solution(1041);
        if (finalResult != 5) {
            throw new Exception("wrong answer - expected " + 5 + " but received " + finalResult);
        }

        finalResult = (new BinaryGap()).solution(328);
        if (finalResult != 2) {
            throw new Exception("wrong answer - expected " + 2 + " but received " + finalResult);
        }

        finalResult = (new BinaryGap()).solution(1024);
        if (finalResult != 0) {
            throw new Exception("wrong answer - expected " + 0 + " but received " + finalResult);
        }

        System.out.println("done");
    }

    public int solution(int N) {
        int current = 0;
        int max = 0;

        boolean openedGate = false;

        // Map<Integer,Integer> indexesMap = new HashMap<Integer,Integer>();

        while (N > 0) {
            // System.out.print("N : " + N);
            if (N % 2 == 0) {
                if (openedGate) {
                    ++current;
                }
            } else {
                openedGate = true;

                max = Math.max(max, current);
                current = 0;
            }

            N = N / 2;

            // System.out.print(" - N : " + N + " - max : " + max + " - current : " + current);
            // System.out.println();
        }

        return max;
    }
}
