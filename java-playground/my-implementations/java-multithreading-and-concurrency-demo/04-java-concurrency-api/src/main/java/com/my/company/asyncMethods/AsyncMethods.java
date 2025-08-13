package com.my.company.asyncMethods;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AsyncMethods {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {

		AsyncMethods classUnderTest = new AsyncMethods();
		CompletableFuture<String> future01 = classUnderTest.calculateHelloAsync().thenApplyAsync(s -> s + " World");
		System.out.println(future01.get()); // Hello World
		
		CompletableFuture<String> future02 = classUnderTest.calculateHelloAsync_createYourOwnExecutor().thenApplyAsync(s -> s + "!!!");
		System.out.println(future02.get()); // Hello World
	}

	public CompletableFuture<String> calculateHelloAsync() throws InterruptedException {

		CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "Hello");
	
	    return completableFuture;
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
