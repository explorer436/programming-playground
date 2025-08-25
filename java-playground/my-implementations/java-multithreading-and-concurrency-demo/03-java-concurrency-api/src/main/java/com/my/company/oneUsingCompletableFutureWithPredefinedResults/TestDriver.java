package com.my.company.oneUsingCompletableFutureWithPredefinedResults;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class TestDriver {

    /**
     * 		The get method throws some checked exceptions.
     * 		1. ExecutionException (encapsulating an exception that occurred during a computation) and
     * 		2. InterruptedException (an exception signifying that a thread executing a method was interrupted):
     */
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        System.out.println("starting main with thread.. " + Thread.currentThread().getName());

        UsingCompletableFutureWithAPredefinedResult classUnderTest = new UsingCompletableFutureWithAPredefinedResult();

        CompletableFuture<String> completedFuture = classUnderTest.returnCompletedFuture();
        System.out.println(completedFuture.getNow(null)); // Already completed!

    }

}
