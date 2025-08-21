package com.my.company.nineCombiningFutures;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;

public class UsingThenCompose {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        UsingThenCompose classUnderTest = new UsingThenCompose();

        System.out.println(classUnderTest.calculateHelloWorldAsync_Sequential(classUnderTest.getHelloCompletableFuture()).get());
    }

    private CompletableFuture<String> getHelloCompletableFuture() {
        return CompletableFuture.supplyAsync(() -> "Hello");
    }

    public CompletableFuture<String> calculateHelloWorldAsync_Sequential (CompletableFuture<String> helloCompletableFuture) {
        return helloCompletableFuture.thenCompose(getStringCompletionStageFunction());
    }

    private static Function<String, CompletionStage<String>> getStringCompletionStageFunction() {
        return s -> CompletableFuture.supplyAsync(() -> s + " World");
    }
}
