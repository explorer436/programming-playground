package com.my.company.datastructures.arrays;

import java.util.Arrays;

public class SearchForANumberInAnArray {

    public static void main(String[] args) {
        int[] A;

    /*
    A = new int[] { 5, 1, 2, 3, 4, 5, 1 };
    System.out.println("result : " + solution(A, 1));

    A = new int[] { 3, 2, 3, 1, 3 };
    System.out.println("result : " + solution(A, 5));
    System.out.println("result : " + solution(A, 4));
    System.out.println("result : " + solution(A, 3));

    System.out.println("result : " + solution(null, 4));
    */

        A = new int[]{5, 1, 2, 3, 4, 5, 1};
        System.out.println("result : " + findNumberInArrayUsingRecursion(A, 1)); // true

        A = new int[]{3, 2, 3, 1, 3};
        System.out.println("result : " + findNumberInArrayUsingRecursion(A, 5)); // false
        System.out.println("result : " + findNumberInArrayUsingRecursion(A, 4)); // false
        System.out.println("result : " + findNumberInArrayUsingRecursion(A, 3)); // true

        A = new int[]{3};
        System.out.println("result : " + findNumberInArrayUsingRecursion(A, 4)); // false

        A = null;
        System.out.println("result : " + findNumberInArrayUsingRecursion(A, 4)); // false
    }

    /*
     * This can be implemented using divide and conquer method.
     * divide the array into two sub-arrays. and recursion.
     * return isNumberFound(subarray1) || isNumberFound(subarray2)
     *
     * This is similar to MaximumAndMinimumElementsInAnArray.java
     */
    public static boolean findNumberInArrayUsingRecursion(int[] anArray, int numberWeAreLookingFor) {
        boolean result = false;

        if (null != anArray && anArray.length != 0) {
            if (anArray.length == 1) {
                if (anArray[0] == numberWeAreLookingFor) {
                    return true;
                } else {
                    return false;
                }
            } else {
                int midPoint = (anArray.length + 1) / 2;
                int[] firstHalf = Arrays.copyOfRange(anArray, 0, midPoint);
                int[] secondHalf = Arrays.copyOfRange(anArray, midPoint, anArray.length);

                result =
                        findNumberInArrayUsingRecursion(firstHalf, numberWeAreLookingFor)
                                || findNumberInArrayUsingRecursion(secondHalf, numberWeAreLookingFor);
            }
        }

        return result;
    }

    /**
     * Why does it have to be this complicated?
     */
    public static String solution(int[] arr, int numberWeAreLookingFor) {
        String result = "NO";

        if (null != arr) {
            int arrayLength = arr.length;

            // 1st comparison
            if (arr[arrayLength - 1] == numberWeAreLookingFor) {
                result = "YES";
            }

            int backup = arr[arrayLength - 1];
            arr[arrayLength - 1] = numberWeAreLookingFor;

            // no termination condition and thus
            // no comparison
            for (int index = 0; ; index++) {
                // this would be executed at-most n times
                // and therefore at-most n comparisons
                if (arr[index] == numberWeAreLookingFor) {
                    // replace arr[n-1] with its actual element
                    // as in original 'arr[]'
                    arr[arrayLength - 1] = backup;

                    // if 'numberWeAreLookingFor' is found before the '(n-1)th'
                    // index, then it is present in the array

                    // final comparison
                    if (index < arrayLength - 1) {
                        result = "YES";
                    }

                    // else "numberWeAreLookingFor" is not present in the array
                }
            }
        }

        return result;
    }
}
