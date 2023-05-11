package com.my.company.datastructures.arrays;

/**
 * A zero-indexed array A consisting of N integers is given. An equilibrium index of this array is
 * any integer P such that 0 ≤ P < N and the sum of elements of lower indices is equal to the sum of
 * elements of higher indices, i.e. A[0] + A[1] + ... + A[P−1] = A[P+1] + ... + A[N−2] + A[N−1]. Sum
 * of zero elements is assumed to be equal to 0. This can happen if P = 0 or if P = N−1.
 *
 * <p>For example, consider the following array A consisting of N = 8 elements:
 *
 * <p>A[0] = -1 A[1] = 3 A[2] = -4 A[3] = 5 A[4] = 1 A[5] = -6 A[6] = 2 A[7] = 1
 *
 * <p>P = 1 is an equilibrium index of this array, because:
 *
 * <p>A[0] = −1 = A[2] + A[3] + A[4] + A[5] + A[6] + A[7]
 *
 * <p>P = 3 is an equilibrium index of this array, because:
 *
 * <p>A[0] + A[1] + A[2] = −2 = A[4] + A[5] + A[6] + A[7]
 *
 * <p>P = 7 is also an equilibrium index, because:
 *
 * <p>A[0] + A[1] + A[2] + A[3] + A[4] + A[5] + A[6] = 0
 *
 * <p>and there are no elements with indices greater than 7.
 *
 * <p>P = 8 is not an equilibrium index, because it does not fulfill the condition 0 ≤ P < N.
 *
 * <p>Now i have to write a function:
 *
 * <p>int solution(int A[], int N);
 *
 * <p>that, given a zero-indexed array A consisting of N integers, returns any of its equilibrium
 * indices. The function should return −1 if no equilibrium index exists.
 *
 * <p>For example, given array A shown above, the function may return 1, 3 or 7, as explained above.
 *
 * <p>Assume that:
 *
 * <p>N is an integer within the range [0..100,000]; each element of array A is an integer within
 * the range [−2,147,483,648..2,147,483,647].
 *
 * <p>here have some Complexity:
 *
 * <p>Elements of input arrays can be modified.
 */
public class EquilibriumIndexOfArray {

    public static void main(String[] args) {
        // TODO

    }

    // TODO implement this on your own.
    int solution(int A[], int N) {

        long sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += (long) A[i];
        }
        long leftSum = 0;
        long rightSum = 0;

        for (int i = 0; i < A.length; i++) {
            rightSum = sum - (leftSum + A[i]);
            if (leftSum == rightSum) {
                return i;
            }
            leftSum += A[i];
        }
        return -1;
    }

    /*
     * In order to avoid O(N^2) and achieve O(N) performance: The key observation for better running time is to update the left/right sums in constant time instead of recomputing them from the scratch.
     */

    // TODO
    int equi(int arr[], int n) {
        if (n == 0) return -1;
        long sum = 0;
        int i;
        for (i = 0; i < n; i++) sum += (long) arr[i];

        long sum_left = 0;
        for (i = 0; i < n; i++) {
            long sum_right = sum - sum_left - (long) arr[i];
            if (sum_left == sum_right) return i;
            sum_left += (long) arr[i];
        }
        return -1;
    }

    // TODO
    public static int equilibriumIndex(int[] array) {
        int INDEX_NOT_FOUND = -1;
        int rSum = 0, lSum = 0;

        for (int index = 0; index < array.length; index++) {
            rSum += array[index];
        }

        for (int index = 0; index < array.length; index++) {
            lSum +=
                    (index == 0) ? 0 : array[index - 1]; // cumulative sum before (left sum) the current index
            rSum -= array[index]; // sum after (right sum) the current index onwards
            if (lSum
                    == rSum) { // if both sums, cumulative sum before the current index and cumulative sum
                // after the current index is equal, we got the equilibrium index
                return index;
            }
        }
        return INDEX_NOT_FOUND;
    }
}
