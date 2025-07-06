package com.my.company.processingResultsOfAsynchronousComputations;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ProcessingResultsOfAsynchronousComputations {

	public CompletableFuture<String> calculateHelloAsync() throws InterruptedException {
		CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "Hello");
	    return completableFuture;
	}	

	public CompletableFuture<String> calculateBeautifulAsync() throws InterruptedException {
		CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "Beautiful");
	    return completableFuture;
	}	

	public CompletableFuture<String> calculateWorldAsync() throws InterruptedException {
		CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "World");
	    return completableFuture;
	}	
}
