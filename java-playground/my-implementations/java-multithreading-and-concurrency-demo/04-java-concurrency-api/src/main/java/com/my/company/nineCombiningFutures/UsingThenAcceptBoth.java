package com.my.company.nineCombiningFutures;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class UsingThenAcceptBoth {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        UsingThenAcceptBoth classUnderTest = new UsingThenAcceptBoth();

        classUnderTest.printHelloWorldAsync();

    }

	private CompletableFuture<String> calculateHelloAsync() throws InterruptedException {
		CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "Hello");
	    return completableFuture;
	}	

	private CompletableFuture<String> calculateWorldAsync() throws InterruptedException {
		CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> " World");
	    return completableFuture;
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
}
