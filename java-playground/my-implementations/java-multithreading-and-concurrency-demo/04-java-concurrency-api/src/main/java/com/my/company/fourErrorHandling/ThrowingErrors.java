package com.my.company.fourErrorHandling;

import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ThrowingErrors {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ThrowingErrors classUnderTest = new ThrowingErrors();

        CompletableFuture<Object> completableFuture03 = classUnderTest.calculateNameAsync_throwException("Bob");
        System.out.println(completableFuture03.get()); // Hello, Bob!

        CompletableFuture<Object> completableFuture04;
        try {
            completableFuture04 = classUnderTest.calculateNameAsync_throwException(null);
            completableFuture04.get(); // java.util.concurrent.ExecutionException
        } catch (Exception e) {
            System.out.println("exception occurred. Here are the details:");
            e.printStackTrace();
        }
    }

    public CompletableFuture<Object> calculateNameAsync_throwException(String name) {
        CompletableFuture<Object> completableFuture = new CompletableFuture<>();

        if (StringUtils.isEmpty(name)) {
            completableFuture.completeExceptionally(new RuntimeException("Calculation failed!"));
        } else {
            completableFuture = CompletableFuture.supplyAsync(() -> {
                return "Hello, " + name + "!";
            });
        }

        return completableFuture;
    }

}
