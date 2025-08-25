package com.my.company.nineCombiningFutures;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class UsingThenCombine {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        UsingThenCombine classUnderTest = new UsingThenCombine();

        System.out.println(classUnderTest.calculateHelloWorldAsync_Parallel().get());

        // Another example:
        System.out.println("Calculating BMI.");
        System.out.println("Your BMI is - " + classUnderTest.getBMI().get()); // Your BMI is - 20.56126561232714

    }

	private CompletableFuture<String> calculateHelloAsync() throws InterruptedException {
		CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "Hello");
	    return completableFuture;
	}	

	private CompletableFuture<String> calculateWorldAsync() throws InterruptedException {
		CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> " World");
	    return completableFuture;
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

    public CompletableFuture<Double> getBMI () throws InterruptedException {
        CompletableFuture<Double> bmiFuture = getWeightInKg()
                .thenCombine(getHeightInCm(), (weightInKg, heightInCm) -> {
                    Double heightInMeter = heightInCm/100;
                    return weightInKg/(heightInMeter*heightInMeter);
                });
        return bmiFuture;
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
}
