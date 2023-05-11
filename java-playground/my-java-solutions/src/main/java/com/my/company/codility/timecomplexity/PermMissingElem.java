package com.my.company.codility.timecomplexity;

import java.util.Arrays;

/**
 * Level : Painless
 *
 * <p>Find the missing element in a given permutation.
 *
 * <p>An array A consisting of N different integers is given. The array contains integers in the
 * range [1..(N + 1)], which means that exactly one element is missing.
 *
 * <p>Your goal is to find that missing element.
 *
 * <p>Write a function:
 *
 * <p>class Solution { public int solution(int[] A); }
 *
 * <p>that, given an array A, returns the value of the missing element.
 *
 * <p>For example, given array A such that: A[0] = 2 A[1] = 3 A[2] = 1 A[3] = 5
 *
 * <p>the function should return 4, as it is the missing element.
 *
 * <p>Write an efficient algorithm for the following assumptions:
 *
 * <p>N is an integer within the range [0..100,000]; the elements of A are all distinct; each
 * element of array A is an integer within the range [1..(N + 1)].
 */
public class PermMissingElem {

    public static void main(String[] args) throws Exception {
        int result;

        int[] A = {2, 3, 1, 5};
        result = solution(A);
        if (result != 4) {
            throw new Exception("wrong answer - expected " + 4 + " but received " + result);
        }

        int[] A2 = {1};
        result = solution(A2);
        if (result != 2) {
            throw new Exception("wrong answer - expected " + 2 + " but received " + result);
        }

        int[] A3 = {1, 2, 3};
        result = solution(A3);
        if (result != 4) {
            throw new Exception("wrong answer - expected " + 4 + " but received " + result);
        }

        int[] A4 = {2, 3, 4};
        result = solution(A4);
        if (result != 1) {
            throw new Exception("wrong answer - expected " + 1 + " but received " + result);
        }

        int[] A5 = {};
        result = solution(A5);
        if (result != 1) {
            throw new Exception("wrong answer - expected " + 1 + " but received " + result);
        }

        System.out.println("done");
    }

    public static int solution(int[] A) {
        int result = 0;
        if (A.length > 0) {
            // O(N*log(N))
            Arrays.sort(A);

            for (int aIndex = 0; aIndex < A.length; aIndex++) {
                if ((aIndex + 1) != A[aIndex]) {
                    result = aIndex + 1;
                    break;
                }
            }
            if (0 == result) {
                result = A[A.length - 1] + 1;
            }
        } else {
            result = 1;
        }
        return result;
    }
}
