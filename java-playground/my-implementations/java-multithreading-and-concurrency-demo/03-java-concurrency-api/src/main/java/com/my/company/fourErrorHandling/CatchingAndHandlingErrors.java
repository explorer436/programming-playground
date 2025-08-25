package com.my.company.fourErrorHandling;

import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CatchingAndHandlingErrors {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CatchingAndHandlingErrors classUnderTest = new CatchingAndHandlingErrors();
        ThrowingErrors throwingErrors = new ThrowingErrors();

        CompletableFuture<String> completableFuture01 = classUnderTest.calculateNameAsync_handleExceptionWithADefaultValue("Bob");
        System.out.println(completableFuture01.get()); // Hello, Bob!

        CompletableFuture<String> completableFuture02 = classUnderTest.calculateNameAsync_handleExceptionWithADefaultValue(null);
        System.out.println(completableFuture02.get()); // Hello, Stranger!

        CompletableFuture<Object> completableFuture03 = throwingErrors.calculateNameAsync_throwException("Bob");
        System.out.println(completableFuture03.get()); // Hello, Bob!

        // ---------------------------

        // Let’s first understand how errors are propagated in a callback chain.
        // Consider the following CompletableFuture callback chain -
        CompletableFuture.supplyAsync(() -> {
            // Code which might throw an exception
            return "Some result";
        }).thenApply(result -> {
            return "processed result";
        }).thenApply(result -> {
            return "result after further processing";
        }).thenAccept(result -> {
            // do something with the final result
        });
        // If an error occurs in the original supplyAsync() task, then none of the thenApply() callbacks will be called and future will be resolved with the exception occurred.
        // If an error occurs in first thenApply() callback then 2nd and 3rd callbacks won’t be called and the future will be resolved with the exception occurred, and so on.

        CompletableFuture<String> maturityFuture01 = classUnderTest.handleExceptionUsingExceptionally(-1);
        System.out.println("Maturity : " + maturityFuture01.get());

        CompletableFuture<String> maturityFuture02 = classUnderTest.handleExceptionUsingTheGenericHandleMethod(-1);
        System.out.println("Maturity : " + maturityFuture02.get());

    }

    public CompletableFuture<String> calculateNameAsync_handleExceptionWithADefaultValue(String name) {
        CompletableFuture<String> completableFuture
                = CompletableFuture.supplyAsync(() -> {
            if (StringUtils.isEmpty(name)) {
                throw new RuntimeException("Computation error!");
            }
            return "Hello, " + name + "!";
        }).handle((s, t) -> s != null ? s : "Hello, Stranger!");

        return completableFuture;
    }

    /*
     * The error will not be propagated further in the callback chain if you handle it once.
     */
    public CompletableFuture<String> handleExceptionUsingExceptionally(Integer age) {
        CompletableFuture<String> maturityFuture = CompletableFuture.supplyAsync(() -> {
            if (age < 0) {
                throw new IllegalArgumentException("Age can not be negative");
            }
            if (age > 18) {
                return "Adult";
            } else {
                return "Child";
            }
        }).exceptionally(ex -> {
            System.out.println("Oops! We have an exception - " + ex.getMessage());
            return "Unknown!";
        });

        return maturityFuture;
    }

    public CompletableFuture<String> handleExceptionUsingTheGenericHandleMethod(Integer age) {
        CompletableFuture<String> maturityFuture = CompletableFuture.supplyAsync(() -> {
            if (age < 0) {
                throw new IllegalArgumentException("Age can not be negative");
            }
            if (age > 18) {
                return "Adult";
            } else {
                return "Child";
            }
        }).handle((res, ex) -> {
            if (ex != null) {
                System.out.println("Oops! We have an exception - " + ex.getMessage());
                return "Unknown!";
            }
            return res;
        });

        return maturityFuture;
    }

}
