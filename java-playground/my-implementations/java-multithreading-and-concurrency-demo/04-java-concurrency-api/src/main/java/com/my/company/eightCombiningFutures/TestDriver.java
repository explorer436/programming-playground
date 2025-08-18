package com.my.company.eightCombiningFutures;

import java.util.concurrent.ExecutionException;

public class TestDriver {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CombiningFutures classUnderTest = new CombiningFutures();

        System.out.println(classUnderTest.calculateHelloWorldAsync_Sequential().get());

        System.out.println(classUnderTest.calculateHelloWorldAsync_Parallel().get());

        classUnderTest.printHelloWorldAsync();

        // Another example:
        System.out.println("Calculating BMI.");
        System.out.println("Your BMI is - " + classUnderTest.getBMI().get()); // Your BMI is - 20.56126561232714

    }
}
