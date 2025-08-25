package com.my.company.sevenThenApply;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;

public class AttachingASequenceOfCallbacksToACompletableFutureUsingThenApply {

    public CompletableFuture<String> calculateHelloAsync() throws InterruptedException {
        return CompletableFuture.supplyAsync(() -> "Hello");
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        AttachingASequenceOfCallbacksToACompletableFutureUsingThenApply classUnderTest = new AttachingASequenceOfCallbacksToACompletableFutureUsingThenApply();


        CompletableFuture<String> welcomeText = classUnderTest.calculateHelloAsync().thenApply(appendXToString(" Beautiful")).thenApply(appendXToString(" World")).thenApply(appendXToString(", !!!!!!!!!!!"));
        System.out.println(welcomeText.get()); // Hello World, !!!!!!!!!!!
    }

    private static Function<String, String> appendXToString(String x) {
        return wishes -> wishes + x;
    }
}
