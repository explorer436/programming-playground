package com.my.company.sevenThenApply;

import java.util.concurrent.*;
import java.util.function.Function;

public class AttachingACallbackToACompletableFutureUsingThenApply {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        AttachingACallbackToACompletableFutureUsingThenApply classUnderTest = new AttachingACallbackToACompletableFutureUsingThenApply();

        System.out.println(classUnderTest.getHelloCompletableFuture().thenApply(appendWithWorld()).get()); // Hello World
    }

    private CompletableFuture<String> getHelloCompletableFuture() {
        return CompletableFuture.supplyAsync(() -> "Hello");
    }

    private static Function<String, String> appendWithWorld() {
        return s -> s + " World";
    }
}
