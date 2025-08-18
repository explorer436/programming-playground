package com.my.company.fiveSupplyAsync;

import java.util.concurrent.*;
import java.util.function.Supplier;

public class WrappingTasksInCompletableFutureUsingSupplyAsync {

    public CompletableFuture<String> getCompletableFuture_WithLambdaExpression_usingSupplyAsync() throws InterruptedException {
        // Using Lambda Expression
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "Hello");

        return completableFuture;
    }

    // CompletableFuture.supplyAsync() takes a Supplier<T> and returns CompletableFuture<T> where T is the type of the value obtained by calling the given supplier.
    public Future<String> getCompletableFuture_WithAnonymousClass_usingSupplyAsync() throws InterruptedException {

        // Run a task specified by a Supplier object asynchronously
        CompletableFuture<String> future = CompletableFuture.supplyAsync(new Supplier<String>() {
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

        return future;
    }

    // Here’s how you can create a thread pool and pass it to one of these methods
	public CompletableFuture<String> calculateHelloAsync_createYourOwnExecutor() throws InterruptedException {
		Executor executor = Executors.newFixedThreadPool(10);
		CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
		    try {
		        TimeUnit.SECONDS.sleep(1);
		    } catch (InterruptedException e) {
		        throw new IllegalStateException(e);
		    }
		    return "Result of the asynchronous computation";
		}, executor);
	    return future;
	}	
}
