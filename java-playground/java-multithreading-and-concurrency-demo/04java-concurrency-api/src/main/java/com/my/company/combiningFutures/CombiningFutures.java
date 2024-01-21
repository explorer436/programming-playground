package com.my.company.combiningFutures;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CombiningFutures {

	public CompletableFuture<String> calculateHelloAsync() throws InterruptedException {
		CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "Hello");
	    return completableFuture;
	}	

	public CompletableFuture<String> calculateWorldAsync() throws InterruptedException {
		CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> " World");
	    return completableFuture;
	}	

	public CompletableFuture<Double> getHeightInCm() throws InterruptedException {
		System.out.println("Retrieving height.");
		CompletableFuture<Double> heightInCmFuture = CompletableFuture.supplyAsync(() -> {
		    try {
		        TimeUnit.SECONDS.sleep(1);
		    } catch (InterruptedException e) {
		       throw new IllegalStateException(e);
		    }
		    return 177.8;
		});
	    return heightInCmFuture;
	}	

	public CompletableFuture<Double> getWeightInKg() throws InterruptedException {
		System.out.println("Retrieving weight.");
		CompletableFuture<Double> weightInKgFuture = CompletableFuture.supplyAsync(() -> {
		    try {
		        TimeUnit.SECONDS.sleep(1);
		    } catch (InterruptedException e) {
		       throw new IllegalStateException(e);
		    }
		    return 65.0;
		});
        return weightInKgFuture;
	}	
}
