package com.my.company.codility.prefixsums;

import java.util.Arrays;

/**
 * See PrefixSums.pdf
 *
 * <p>I would argue it is not the best choice, since the prefix sum part of the problem is hidden by
 * the complexity of the determining how the picker moves in the array.
 */
public class MushroomPicker {

    public static void main(String[] args) {
        int A[] = new int[]{};

    /*
    A = new int[]{2,3,7,5,1,3,9};
    System.out.println("maximum number of mushrooms picked from the array " + Arrays.toString(A) +
    	" when current position is 4 and maximum moves allowed is 6 is " + solution1_incorrectSolution(A, 4, 6));
    // expected 25

    A = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    System.out.println("maximum number of mushrooms picked from the array " + Arrays.toString(A) +
       	" when current position is 5 and maximum moves allowed is 3 is " + solution1_incorrectSolution(A, 5, 3));
    // expected 6 + 7 + 8 + 9 = 30

    A = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    System.out.println("maximum number of mushrooms picked from the array " + Arrays.toString(A) +
       	" when current position is 8 and maximum moves allowed is 3 is " + solution1_incorrectSolution(A, 8, 3));
    // there are two possible solutions to this.
    // 1. A[8] -> A[9], A[9] -> A[8], A[8] -> A[7] = 9 + 10 + 8 = 27
    // 2. A[8] -> A[7], A[7] -> A[8], A[8] -> A[9] = 9 + 8 + 10 = 27
    // expected 27

    A = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    System.out.println("maximum number of mushrooms picked from the array " + Arrays.toString(A) +
       	" when current position is 8 and maximum moves allowed is 2 is " + solution1_incorrectSolution(A, 2, 3));
    // expected 27
     *
     */

        System.out.println();

        A = new int[]{2, 3, 7, 5, 1, 3, 9};
        System.out.println(
                "maximum number of mushrooms picked from the array "
                        + Arrays.toString(A)
                        + " when current position is 4 and maximum moves allowed is 6 is "
                        + solution(A, 4, 6));
        // expected 25

        A = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(
                "maximum number of mushrooms picked from the array "
                        + Arrays.toString(A)
                        + " when current position is 5 and maximum moves allowed is 3 is "
                        + solution(A, 5, 3));
        // expected 6 + 7 + 8 + 9 = 30

        A = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(
                "maximum number of mushrooms picked from the array "
                        + Arrays.toString(A)
                        + " when current position is 8 and maximum moves allowed is 3 is "
                        + solution(A, 8, 3));
        // there are two possible solutions to this.
        // 1. A[8] -> A[9], A[9] -> A[8], A[8] -> A[7] = 9 + 10 + 8 = 27
        // 2. A[8] -> A[7], A[7] -> A[8], A[8] -> A[9] = 9 + 8 + 10 = 27
        // expected 27

        A = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println(
                "maximum number of mushrooms picked from the array "
                        + Arrays.toString(A)
                        + " when current position is 8 and maximum moves allowed is 2 is "
                        + solution(A, 2, 3));
        // expected 27

        A = new int[]{10, 9, 8};
        System.out.println(
                "maximum number of mushrooms picked from the array "
                        + Arrays.toString(A)
                        + " when current position is 2 and maximum moves allowed is 15 is "
                        + solution(A, 2, 15));
        // expected 27

        A = new int[]{10, 9, 8, 7};
        System.out.println(
                "maximum number of mushrooms picked from the array "
                        + Arrays.toString(A)
                        + " when current position is 2 and maximum moves allowed is 15 is "
                        + solution(A, 2, 15));
        // expected 34
    }

    private static int solution(int A[], int currentPosition, int maxMovesAllowed) {
        int[] prefixSumsOfA = PrefixSums.prefixSumsOfAnArray(A);

        int currentMaxMushroomsPickedUp = 0;

        // assume that the picker would go left first and then turn directions.
        // this also includes the scenario where the picker would go left only and does not turn right.
        for (int i = 0; i < maxMovesAllowed; i++) {
            int leftPosition = currentPosition - i;

            int calculatedRightPosition = currentPosition + (maxMovesAllowed - (i * 2));
            // we have to keep count of all the mushrooms picked up beginning at currentPosition.
            // so, even if calculatedRightPosition is less than currentPosition, we need to retain the
            // count till currentPosition.
            int practicalRightPosition =
                    calculatedRightPosition > currentPosition ? calculatedRightPosition : currentPosition;
            // if calculatedRightPosition is greater than the length of the array, calculate the result
            // using the last element of the array.
            practicalRightPosition =
                    calculatedRightPosition >= A.length ? A.length - 1 : practicalRightPosition;

            int prefSumRightVal = prefixSumsOfA[practicalRightPosition];
            int prefSumLeftVal = (leftPosition > 0) ? prefixSumsOfA[leftPosition - 1] : 0;

            int mushroomsPickedInThisTrip = prefSumRightVal - prefSumLeftVal;

            if (mushroomsPickedInThisTrip > currentMaxMushroomsPickedUp) {
                currentMaxMushroomsPickedUp = mushroomsPickedInThisTrip;
            }
        }

        // assume that the picker would go right first and then turn directions.
        // this also includes the scenario where the picker would go right only and does not turn left.
        for (int i = 0; i < maxMovesAllowed; i++) {
            int rightPosition = currentPosition + i;
            // if rightPosition is greater than the length of the array, calculate the result using the
            // last element of the array.
            int practicalRightPosition = rightPosition > A.length ? A.length : rightPosition;

            int calculatedLeftPosition = currentPosition - (maxMovesAllowed - (i * 2));
            // we have to keep count of all the mushrooms picked up beginning at currentPosition.
            // so, even if calculatedLeftPosition is less than currentPosition, we need to retain the
            // count till currentPosition.
            int practicalLeftPosition =
                    calculatedLeftPosition < currentPosition ? calculatedLeftPosition : currentPosition;
            // if calculatedLeftPosition is less than zero, calculate the result using the first element
            // of the array.
            practicalLeftPosition = calculatedLeftPosition <= 0 ? 0 : practicalLeftPosition;

            int prefSumLeftVal = prefixSumsOfA[practicalLeftPosition];
            int prefSumRightVal =
                    (practicalRightPosition > 0) ? prefixSumsOfA[practicalRightPosition - 1] : 0;

            int mushroomsPickedInThisTrip = prefSumLeftVal - prefSumRightVal;

            if (mushroomsPickedInThisTrip > currentMaxMushroomsPickedUp) {
                currentMaxMushroomsPickedUp = mushroomsPickedInThisTrip;
            }
        }

        return currentMaxMushroomsPickedUp;
    }

    /**
     * Trying to handle everything using boolean indicators for turning directions turned out to be
     * complex.
     */
    private static int solution1_incorrectSolution(
            int A[], int currentPosition, int maxMovesAllowed) {
        int[] prefixSumsOfA = PrefixSums.prefixSumsOfAnArray(A);
        // System.out.println("prefixSumsOfA : " + Arrays.toString(prefixSumsOfA));
        // [2, 5, 12, 17, 18, 21, 30]

        boolean directionChanged = false;
        int currentMaxMushroomsPickedUp = 0;
        for (int i = 0; i < maxMovesAllowed; i++) {
            int leftPosition = currentPosition - i;

            int calculatedRightPosition = currentPosition + (maxMovesAllowed - (i * 2));

            // we have to keep count of all the mushrooms picked up beginning at currentPosition.
            // so, even if calculatedRightPosition is less than currentPosition, we need to retain the
            // count till currentPosition.
            int practicalRightPosition =
                    calculatedRightPosition > currentPosition ? calculatedRightPosition : currentPosition;

            int prefSumRightVal;
            int prefSumLeftVal;
            if (directionChanged) {
                // since the picker already changed direction one time, she cannot go in the opposite
                // direction.
                practicalRightPosition =
                        calculatedRightPosition > A.length ? A.length - 1 : practicalRightPosition;
                prefSumRightVal = prefixSumsOfA[practicalRightPosition];
                prefSumLeftVal = (leftPosition > 0) ? prefixSumsOfA[leftPosition - 1] : 0;
            } else {
                directionChanged = true;
                practicalRightPosition = A.length - (maxMovesAllowed - (i * 2));
                prefSumRightVal = prefixSumsOfA[A.length - 1];
                prefSumLeftVal =
                        (leftPosition < practicalRightPosition)
                                ? prefixSumsOfA[leftPosition - 1]
                                : prefixSumsOfA[practicalRightPosition - 1];
            }

            int mushroomsPickedInThisTrip = prefSumRightVal - prefSumLeftVal;
            // System.out.println("mushroomsPickedInThisTrip : " + mushroomsPickedInThisTrip);

            if (mushroomsPickedInThisTrip > currentMaxMushroomsPickedUp) {
                currentMaxMushroomsPickedUp = mushroomsPickedInThisTrip;
            }
        }

        return currentMaxMushroomsPickedUp;
    }
}
