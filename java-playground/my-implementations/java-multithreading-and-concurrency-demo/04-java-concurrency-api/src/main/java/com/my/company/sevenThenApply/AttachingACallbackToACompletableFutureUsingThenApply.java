package com.my.company.sevenThenApply;

import com.my.company.fiveSupplyAsync.WrappingTasksInCompletableFutureUsingSupplyAsync;

import java.util.concurrent.*;
import java.util.function.Function;

public class AttachingACallbackToACompletableFutureUsingThenApply {

    WrappingTasksInCompletableFutureUsingSupplyAsync wrappingTasksInCompletableFutureUsingSupplyAsync = new WrappingTasksInCompletableFutureUsingSupplyAsync();

    public CompletableFuture<String> getCompletableFuture_WithLambdaExpression_usingSupplyAsync() throws InterruptedException {

        // Attach a callback to the Future using thenApply()
        return wrappingTasksInCompletableFutureUsingSupplyAsync.getCompletableFuture_WithLambdaExpression_usingSupplyAsync().thenApplyAsync(appendWithWorld());

    }

    // Using Lambda Expression
    private static Function<String, String> appendWithWorld() {
        return s -> s + " World";
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        AttachingACallbackToACompletableFutureUsingThenApply classUnderTest = new AttachingACallbackToACompletableFutureUsingThenApply();

        System.out.println(classUnderTest.getCompletableFuture_WithLambdaExpression_usingSupplyAsync().get()); // Hello World

        System.out.println("done");
    }
}
