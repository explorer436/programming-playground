package com.my.company.sevenThenApply;

import java.util.concurrent.ExecutionException;

public class TestDriver {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ProcessResultsUsingThenApply classUnderTest = new ProcessResultsUsingThenApply();

        System.out.println(classUnderTest.getCompletableFuture_WithLambdaExpression_usingSupplyAsync().get()); // Hello World

        System.out.println("done");
    }

}
