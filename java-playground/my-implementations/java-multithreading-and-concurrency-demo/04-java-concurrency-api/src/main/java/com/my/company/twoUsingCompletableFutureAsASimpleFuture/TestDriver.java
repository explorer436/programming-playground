package com.my.company.twoUsingCompletableFutureAsASimpleFuture;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class TestDriver {

    /**
     * 		The get method throws some checked exceptions.
     * 		1. ExecutionException (encapsulating an exception that occurred during a computation) and
     * 		2. InterruptedException (an exception signifying that a thread executing a method was interrupted):
     */
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        System.out.println("starting main with thread.. " + Thread.currentThread().getName());

        UsingCompletableFutureAsASimpleFuture classUnderTest = new UsingCompletableFutureAsASimpleFuture();

        // Call the calculateHelloAsync() method, receive the Future instance.
        Future<String> completableFuture = classUnderTest.calculateHelloAsync();

        // Call the get method on the future instance when we're ready to block for the result.
        // The CompletableFuture.get() method is blocking. It waits until the Future is completed and returns the result after its completion.
        String result = completableFuture.get();
        System.out.println("result: " + result); // Hello

    }

}
