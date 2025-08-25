package com.my.company.oneUsingCompletableFutureWithPredefinedResults;

import java.util.concurrent.CompletableFuture;

public class UsingCompletableFutureWithAPredefinedResult {

    public CompletableFuture<String> returnCompletedFuture() throws InterruptedException {

        CompletableFuture<String> completableFuture = CompletableFuture.completedFuture("Already completed!");

        return completableFuture;
    }

}
