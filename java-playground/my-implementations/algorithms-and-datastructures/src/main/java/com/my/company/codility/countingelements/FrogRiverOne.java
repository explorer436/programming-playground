package com.my.company.codility.countingelements;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.my.company.utility.PrintUtils;

public class FrogRiverOne {

    public static void main(String[] args) throws Exception {
        int result;

        int[] A = {1, 3, 1, 4, 2, 3, 5, 4};
        result = solution(5, A);
        if (result != 6) {
            throw new Exception("wrong answer - expected " + 6 + " but received " + result);
        }

        int[] A2 = {3};
        result = solution(5, A2);
        if (result != -1) {
            throw new Exception("wrong answer - expected " + -1 + " but received " + result);
        }

        int[] A3 = {3};
        result = solution(2, A3);
        if (result != -1) {
            throw new Exception("wrong answer - expected " + -1 + " but received " + result);
        }

        int[] A4 = {3};
        result = solution(3, A4);
        if (result != -1) {
            throw new Exception("wrong answer - expected " + -1 + " but received " + result);
        }

        int[] A5 = {1};
        result = solution(1, A5);
        if (result != 0) {
            throw new Exception("wrong answer - expected " + 0 + " but received " + result);
        }

        int[] A6 = {2, 2, 2, 2, 2};
        result = solution(2, A6);
        if (result != -1) {
            throw new Exception("wrong answer - expected " + -1 + " but received " + result);
        }

        System.out.println("done");
    }

    /**
     * | 1 2 3 4 5 | |---------------------------------------| | A[0] | | A[1] | | A[2] | | A[3] | |
     * A[4] | | A[5] | | A[6] | | A[7] |
     */
    public static int solution(int X, int[] A) {
        Map<Integer, Integer> indexesMap = new HashMap<Integer, Integer>();
        // start from the back - because we want to find the minimum index at which the condition is
        // satisfied.
        for (int i = A.length - 1; i >= 0; i--) {
            indexesMap.put(A[i], i);
        }

        PrintUtils.printMap(indexesMap);
        // indexedMap key - value pairs
        // 1 = 0
        // 2 = 4
        // 3 = 1
        // 4 = 3
        // 5 = 6

        // now find the highest value in the map
        int earlistTime = -1;

        if (indexesMap.isEmpty()) {
            return -1;
        } else {
            Set<Integer> keys = indexesMap.keySet();

            boolean allLeavesPresent = true;

            // this for loop and the for loop in the below if condition can be combined.
            // there is no need to traverse through the keySet first.
            // if indexesMap.get(i) returns null, it means that there is no value for that key and
            // it means that there is no solution to the problem. in that case, return -1.
            for (int j = 1; j <= X; j++) {
                if (!keys.contains(j)) {
                    allLeavesPresent = false;
                    break;
                }
            }

            if (allLeavesPresent) {
                // the highest value in the map is the maximum time the frog has to wait to cross the river.
                for (int i = 1; i <= X; i++) {
                    Integer val = (Integer) indexesMap.get(i);

                    if (val > earlistTime) {
                        earlistTime = val;
                    }
                }
            }
        }
        return earlistTime;
    }
}
