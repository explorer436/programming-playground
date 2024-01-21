package com.my.company.completableFutureWithEncapsulatedComputationLogic;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class TestDriver {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CompletableFutureWithEncapsulatedComputationLogic classUnderTest = new CompletableFutureWithEncapsulatedComputationLogic();

        Future<Void> completableFuture01 = classUnderTest.getCompletableFuture_WithAnonymousClass_usingRunAsync();
        // Block and wait for the future to complete
        completableFuture01.get();

        Future<Void> completableFuture02 = classUnderTest.getCompletableFuture_WithLambdaExpression_usingRunAsync();
        // Block and wait for the future to complete
        completableFuture02.get();

        // Call the useSupplyAsync_WithALambdaExpression() method, receive the Future instance.
        Future<String> completableFuture03 = classUnderTest.getCompletableFuture_WithLambdaExpression_usingSupplyAsync();

        // Call the get method on the future instance when we're ready to block for the result.
        System.out.println("completableFuture03.get(): " + completableFuture03.get()); // Hello

        // Call the useSupplyAsync_createSupplierInstance() method, receive the Future instance.
        Future<String> completableFuture04 = classUnderTest.getCompletableFuture_WithAnonymousClass_usingSupplyAsync();

        // Call the get method on the future instance when we're ready to block for the result.
        System.out.println("completableFuture04.get(): " + completableFuture04.get()); // Result of the asynchronous computation
    }

}
