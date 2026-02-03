package com.my.company.hackerrank;

import java.util.List;

import com.my.company.numbers.GCDOfNumbersInAnArray;
import com.my.company.numbers.LCMOfNumbersInACollection;

public class BetweenTwoSets {

    GCDOfNumbersInAnArray gcd = new GCDOfNumbersInAnArray();

    public int getTotalX(List<Integer> a, List<Integer> b) {

        if (a.contains(0)) {
            return 0;
        }

        int lcmOfA = LCMOfNumbersInACollection.getLcmOfNumbersInAList(a);
        System.out.println("lcmOfA : " + lcmOfA);

        int gcdOfB = gcd.getGcdOfNumbersInAList(b);
        System.out.println("gcdOfB : " + gcdOfB);

        int count = 0;
        /**
         * We have to run a multiplication table on lcmOfA as long it is less than or equal to the first
         * element of array B.
         */
        for (int i = 1; i <= b.get(0); i++) {
            int lcmOfAMultiple = i * lcmOfA;

            if (lcmOfAMultiple <= gcdOfB && gcdOfB % lcmOfAMultiple == 0) {
                count = count + 1;
            } else if (lcmOfAMultiple > gcdOfB) {
                // time to break out of the loop.
                break;
            }
        }

        return count;
    }
}
