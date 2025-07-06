package com.my.company.usingCompletableFutureAsASimpleFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class UsingCompletableFutureAsASimpleFuture {
	
	/**
	 * A method that creates a CompletableFuture instance, then spins off some computation in another thread and returns the Future immediately.
	 * 
	 * When the computation is done, the method completes the Future by providing the result to the complete method.
	 * 
	 * To spin off the computation, we use the Executor API. 
	 * This method of creating and completing a CompletableFuture can be used together with any concurrency mechanism or API, including raw threads.
	 */
	public Future<String> calculateHelloAsync() throws InterruptedException {

	    CompletableFuture<String> completableFuture = new CompletableFuture<>();
	
	    // CompletableFuture.complete() method is used to manually complete a Future.
	    // The get() method blocks until the Future is complete. So, if the complete() is not implemented, the get call will be blocked forever.
	    Executors.newCachedThreadPool().submit(() -> {
	        Thread.sleep(1000 * 2);
	        completableFuture.complete("Hello");
	        return null;
	    });
	
	    return completableFuture;
	}	
	
	/**
		First of all, the CompletableFuture class implements the Future interface. So, we can use it as a Future implementation, but with additional completion logic.	

		For example, we can create an instance of this class with a no-arg constructor to represent some future result, hand it out to the consumers, and complete it at some time in the future using the complete method. 
		The consumers may use the get method to block the current thread until this result is provided.
	*/
	
	/**
	 * 
	    The simplest case creates an already completed CompletableFuture with a predefined result.
	    Usually, this may act as the starting stage in your computation.
		The getNow(null) returns the result if completed (which is obviously the case), but otherwise returns null (the argument).

	    If we already know the result of a computation, we can use the static completedFuture method with an argument that represents a result of this computation. 
	    Consequently, the get method of the Future will never block, immediately returning this result instead:

	 *
	 */
	public CompletableFuture<String> returnCompletedFuture() throws InterruptedException {

		CompletableFuture<String> completableFuture = CompletableFuture.completedFuture("Already completed!");

        return completableFuture;
    }

}
