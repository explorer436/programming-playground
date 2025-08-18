package com.my.company.sevenThenApply;

import com.my.company.fiveSupplyAsync.WrappingTasksInCompletableFutureUsingSupplyAsync;

import java.util.concurrent.*;

public class ProcessResultsUsingThenApply {

    WrappingTasksInCompletableFutureUsingSupplyAsync wrappingTasksInCompletableFutureUsingSupplyAsync = new WrappingTasksInCompletableFutureUsingSupplyAsync();

    public CompletableFuture<String> getCompletableFuture_WithLambdaExpression_usingSupplyAsync() throws InterruptedException {

        // Using Lambda Expression
        return wrappingTasksInCompletableFutureUsingSupplyAsync.getCompletableFuture_WithLambdaExpression_usingSupplyAsync().thenApplyAsync(s -> s + " World");

    }
}
