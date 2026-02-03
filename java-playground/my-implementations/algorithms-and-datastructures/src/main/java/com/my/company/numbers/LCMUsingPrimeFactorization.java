package com.my.company.numbers;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static com.my.company.numbers.PrimeFactorsOfANumber.getPrimeFactors;

public class LCMUsingPrimeFactorization {

    public int lcmUsingPrimeFactorizationApproach(int number1, int number2) {
        if (number1 == 0 || number2 == 0) {
            return 0;
        }

        Map<Integer, Integer> primeFactorsForNum1 = getPrimeFactors(number1);
        Map<Integer, Integer> primeFactorsForNum2 = getPrimeFactors(number2);

        Set<Integer> primeFactorsUnionSet = new HashSet<>(primeFactorsForNum1.keySet());
        primeFactorsUnionSet.addAll(primeFactorsForNum2.keySet());

        int lcm = 1;

        for (Integer primeFactor : primeFactorsUnionSet) {
            lcm *=
                    Math.pow(
                            primeFactor,
                            Math.max(
                                    primeFactorsForNum1.getOrDefault(primeFactor, 0),
                                    primeFactorsForNum2.getOrDefault(primeFactor, 0)));
        }

        return lcm;
    }
}
