package com.my.company.fiveSupplyAsync;

import java.util.concurrent.*;
import java.util.function.Supplier;

public class WrappingTasksInCompletableFutureUsingSupplyAsync {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        WrappingTasksInCompletableFutureUsingSupplyAsync classUnderTest = new WrappingTasksInCompletableFutureUsingSupplyAsync();

        System.out.println(classUnderTest.calculateHelloAsync_createYourOwnExecutor().get()); // Hello World

        // Call the useSupplyAsync_WithALambdaExpression() method, receive the Future instance.
        // Call the get method on the future instance when we're ready to block for the result.
        System.out.println("completableFuture03.get(): " + classUnderTest.getCompletableFuture_WithLambdaExpression_usingSupplyAsync().get()); // Hello

        // Call the useSupplyAsync_createSupplierInstance() method, receive the Future instance.
        // Call the get method on the future instance when we're ready to block for the result.
        System.out.println("completableFuture04.get(): " + classUnderTest.getCompletableFuture_WithAnonymousClass_usingSupplyAsync().get()); // Result of the asynchronous computation

        System.out.println("done");
    }

    // Using Lambda Expression
    public CompletableFuture<String> getCompletableFuture_WithLambdaExpression_usingSupplyAsync() throws InterruptedException {
        return CompletableFuture.supplyAsync(() -> "Hello");
    }

    // CompletableFuture.supplyAsync() takes a Supplier<T> and returns CompletableFuture<T> where T is the type of the value obtained by calling the given supplier.
    public Future<String> getCompletableFuture_WithAnonymousClass_usingSupplyAsync() throws InterruptedException {

        // Run a task specified by a Supplier object asynchronously
        return CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new IllegalStateException(e);
                }
                return "Result of the asynchronous computation";
            }
        });
    }

    // We can create a thread pool and pass it to one of these methods
    public CompletableFuture<String> calculateHelloAsync_createYourOwnExecutor() throws InterruptedException {
        Executor executor = Executors.newFixedThreadPool(10);
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "Result of the asynchronous computation";
        }, executor);
    }
}
