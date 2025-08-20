package com.my.company.sixRunAsync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Slf4j
public class WrappingTasksInCompletableFutureUsingRunAsync {

	public Future<Void> getCompletableFuture_WithAnonymousClass_usingRunAsync() {
		CompletableFuture<Void> future = CompletableFuture.runAsync(new Runnable() {
		    @Override
		    public void run() {
		        // Simulate a long-running Job
		        try {
		            TimeUnit.SECONDS.sleep(1);
		        } catch (InterruptedException e) {
		            throw new IllegalStateException(e);
		        }
                log.info("I'll run in a separate thread than the main thread.");
		    }
		});
		return future;
	}	

	public Future<Void> getCompletableFuture_WithLambdaExpression_usingRunAsync() {
		// Using Lambda Expression
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
		    // Simulate a long-running Job   
		    try {
		        TimeUnit.SECONDS.sleep(1);
		    } catch (InterruptedException e) {
		        throw new IllegalStateException(e);
		    }
            log.info("I'll run in a separate thread than the main thread.");
		});
		return future;
	}

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        log.info("main started");

        WrappingTasksInCompletableFutureUsingRunAsync classUnderTest = new WrappingTasksInCompletableFutureUsingRunAsync();

        Future<Void> completableFuture01 = classUnderTest.getCompletableFuture_WithAnonymousClass_usingRunAsync();
        // Block and wait for the future to complete
        completableFuture01.get();

        Future<Void> completableFuture02 = classUnderTest.getCompletableFuture_WithLambdaExpression_usingRunAsync();
        // Block and wait for the future to complete
        completableFuture02.get();
    }
}
