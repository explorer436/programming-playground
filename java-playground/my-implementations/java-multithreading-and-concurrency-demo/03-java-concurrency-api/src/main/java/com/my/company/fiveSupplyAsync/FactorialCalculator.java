package com.my.company.fiveSupplyAsync;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class FactorialCalculator {

    // Recursive method to calculate factorial
    private static long calculateFactorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        int number = 10;

        // Create a CompletableFuture to calculate factorial asynchronously
        CompletableFuture<Long> factorialFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("Calculating factorial for " + number + " in a separate thread...");
            return calculateFactorial(number);
        });

        // You can perform other tasks here while the factorial is being calculated

        try {
            // Get the result (this will block until the computation is complete)
            long result = factorialFuture.get();
            System.out.println("Factorial of " + number + " is: " + result);
        } catch (InterruptedException | ExecutionException e) {
            System.err.println("Error calculating factorial: " + e.getMessage());
        }
    }
}