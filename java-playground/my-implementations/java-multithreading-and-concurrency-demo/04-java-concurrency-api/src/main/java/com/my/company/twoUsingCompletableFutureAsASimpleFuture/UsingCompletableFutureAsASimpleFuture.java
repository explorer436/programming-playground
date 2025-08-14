package com.my.company.twoUsingCompletableFutureAsASimpleFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class UsingCompletableFutureAsASimpleFuture {


    public Future<String> calculateHelloAsync() throws InterruptedException {

        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        // CompletableFuture.complete() method is used to manually complete a Future.
        // The get() method blocks until the Future is complete. So, if the complete() is not implemented, the get call will be blocked forever.
        Executors.newCachedThreadPool().submit(() -> {
            Thread.sleep(1000 * 2);
            completableFuture.complete("Hello");
            return null;
        });

        return completableFuture;
    }

}
