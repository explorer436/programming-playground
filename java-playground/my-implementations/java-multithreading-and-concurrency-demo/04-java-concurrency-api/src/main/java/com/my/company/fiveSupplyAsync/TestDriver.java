package com.my.company.fiveSupplyAsync;

import java.util.concurrent.ExecutionException;

public class TestDriver {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        WrappingTasksInCompletableFutureUsingSupplyAsync classUnderTest = new WrappingTasksInCompletableFutureUsingSupplyAsync();

        // CompletableFuture<String> future02 = classUnderTest.calculateHelloAsync_createYourOwnExecutor().thenApplyAsync(s -> s + "!!!");
        System.out.println(classUnderTest.calculateHelloAsync_createYourOwnExecutor().get()); // Hello World

        // Call the useSupplyAsync_WithALambdaExpression() method, receive the Future instance.
        // Call the get method on the future instance when we're ready to block for the result.
        System.out.println("completableFuture03.get(): " + classUnderTest.getCompletableFuture_WithLambdaExpression_usingSupplyAsync().get()); // Hello

        // Call the useSupplyAsync_createSupplierInstance() method, receive the Future instance.
        // Call the get method on the future instance when we're ready to block for the result.
        System.out.println("completableFuture04.get(): " + classUnderTest.getCompletableFuture_WithAnonymousClass_usingSupplyAsync().get()); // Result of the asynchronous computation

        System.out.println("done");
    }

}
