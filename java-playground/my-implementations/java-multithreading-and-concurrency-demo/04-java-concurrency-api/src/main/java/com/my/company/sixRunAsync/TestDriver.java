package com.my.company.sixRunAsync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Slf4j
public class TestDriver {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        log.info("main started");

        WrappingTasksInCompletableFutureUsingRunAsync classUnderTest = new WrappingTasksInCompletableFutureUsingRunAsync();

        Future<Void> completableFuture01 = classUnderTest.getCompletableFuture_WithAnonymousClass_usingRunAsync();
        // Block and wait for the future to complete
        completableFuture01.get();

        Future<Void> completableFuture02 = classUnderTest.getCompletableFuture_WithLambdaExpression_usingRunAsync();
        // Block and wait for the future to complete
        completableFuture02.get();
    }

}
