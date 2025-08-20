package com.my.company.nineCombiningFutures;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class UsingThenCompose {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        UsingThenCompose classUnderTest = new UsingThenCompose();

        System.out.println(classUnderTest.calculateHelloWorldAsync_Sequential().get());
    }

	private CompletableFuture<String> calculateHelloAsync() throws InterruptedException {
		CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "Hello");
	    return completableFuture;
	}

    public CompletableFuture<String> calculateHelloWorldAsync_Sequential () throws InterruptedException {
        return calculateHelloAsync().thenCompose(s -> CompletableFuture.supplyAsync(() -> s + " World"));
    }
}
