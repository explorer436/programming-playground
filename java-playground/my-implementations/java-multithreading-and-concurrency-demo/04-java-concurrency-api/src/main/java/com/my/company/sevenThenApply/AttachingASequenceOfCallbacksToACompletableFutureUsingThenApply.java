package com.my.company.sevenThenApply;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;

public class AttachingASequenceOfCallbacksToACompletableFutureUsingThenApply {

	public CompletableFuture<String> calculateHelloAsync() throws InterruptedException {
		return CompletableFuture.supplyAsync(() -> "Hello");
	}	

	public CompletableFuture<String> calculateBeautifulAsync() throws InterruptedException {
		return CompletableFuture.supplyAsync(() -> "Beautiful");
	}	

	public CompletableFuture<String> calculateWorldAsync() throws InterruptedException {
		return CompletableFuture.supplyAsync(() -> "World");
	}

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        AttachingASequenceOfCallbacksToACompletableFutureUsingThenApply classUnderTest = new AttachingASequenceOfCallbacksToACompletableFutureUsingThenApply();


        CompletableFuture<String> welcomeText = classUnderTest.calculateHelloAsync().thenApply(appendStringWith(" World")).thenApply(appendStringWith(", !!!!!!!!!!!"));
        System.out.println(welcomeText.get()); // Hello World, !!!!!!!!!!!
    }

    private static Function<String, String> appendStringWith(String x) {
        return wishes -> {
            return wishes + x;
        };
    }
}
