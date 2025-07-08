package com.my.company.numbers;

import com.my.company.utility.PrintUtils;

import java.util.HashMap;
import java.util.Map;

public class PrimeFactorsOfANumber {

    public static void main(String[] args) {
        Map<Integer, Integer> primeFactorsMapFor12 = getPrimeFactors(12);
        System.out.println("prime factors for 12");
        PrintUtils.printMap(primeFactorsMapFor12);

        System.out.println();

        Map<Integer, Integer> primeFactorsMapFor18 = getPrimeFactors(18);
        System.out.println("prime factors for 18");
        PrintUtils.printMap(primeFactorsMapFor18);

        System.out.println();
    }


    public static Map<Integer, Integer> getPrimeFactors(int number) {
        int absNumber = Math.abs(number);

        Map<Integer, Integer> primeFactorsMap = new HashMap<Integer, Integer>();

        for (int factor = 2; factor <= absNumber; factor++) {
            while (absNumber % factor == 0) {
                Integer power = primeFactorsMap.get(factor);
                if (power == null) {
                    power = 0;
                }
                primeFactorsMap.put(factor, power + 1);
                absNumber /= factor;
            }
        }

        return primeFactorsMap;
    }
}