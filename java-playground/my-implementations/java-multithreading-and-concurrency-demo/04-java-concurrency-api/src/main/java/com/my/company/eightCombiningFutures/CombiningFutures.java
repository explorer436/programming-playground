package com.my.company.eightCombiningFutures;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CombiningFutures {

	private CompletableFuture<String> calculateHelloAsync() throws InterruptedException {
		CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "Hello");
	    return completableFuture;
	}	

	private CompletableFuture<String> calculateWorldAsync() throws InterruptedException {
		CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> " World");
	    return completableFuture;
	}

    public CompletableFuture<String> calculateHelloWorldAsync_Sequential () throws InterruptedException {
        return calculateHelloAsync().thenCompose(s -> CompletableFuture.supplyAsync(() -> s + " World"));
    }

    public CompletableFuture<String> calculateHelloWorldAsync_Parallel () throws InterruptedException {
        return calculateHelloAsync().thenCombine(CompletableFuture.supplyAsync(() -> {
            try {
                return calculateWorldAsync();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }), (s1, s2) -> {
            try {
                return s1 + s2.get();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void printHelloWorldAsync () throws InterruptedException {
        calculateHelloAsync().thenAcceptBoth(CompletableFuture.supplyAsync(() -> {
            try {
                return calculateWorldAsync();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }), (s1, s2) -> {
            try {
                System.out.println("printing the result in printHelloWorldAsync: " + s1 + s2.get());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        });
    }

	private CompletableFuture<Double> getHeightInCm() throws InterruptedException {
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

	private CompletableFuture<Double> getWeightInKg() throws InterruptedException {
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

    public CompletableFuture<Double> getBMI () throws InterruptedException {
        CompletableFuture<Double> bmiFuture = getWeightInKg()
                .thenCombine(getHeightInCm(), (weightInKg, heightInCm) -> {
                    Double heightInMeter = heightInCm/100;
                    return weightInKg/(heightInMeter*heightInMeter);
                });
        return bmiFuture;
    }
}
