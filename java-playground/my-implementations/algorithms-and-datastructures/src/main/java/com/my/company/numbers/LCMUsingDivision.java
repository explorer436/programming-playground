package com.my.company.numbers;

public class LCMUsingDivision {

    public static void main(String[] args) {
        System.out.println("LCM of 12 and 18 is : " + lcm_MultiplicationIsAddition(12, 18));
    }

    public static int lcm_MultiplicationIsAddition(int number1, int number2) {
        if (number1 == 0 || number2 == 0) {
            return 0;
        }

        int absNumber1 = Math.abs(number1);
        int absNumber2 = Math.abs(number2);
        int absHigherNumber = Math.max(absNumber1, absNumber2);
        int absLowerNumber = Math.min(absNumber1, absNumber2);
        int lcm = absHigherNumber;
        while (lcm % absLowerNumber != 0) {
            lcm += absHigherNumber;
        }
        return lcm;
    }
}
