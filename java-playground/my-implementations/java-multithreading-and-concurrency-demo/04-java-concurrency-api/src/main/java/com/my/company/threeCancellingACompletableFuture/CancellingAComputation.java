package com.my.company.threeCancellingACompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CancellingAComputation {

	public static void main(String[] args) {

	    CompletableFuture<String> cf = CompletableFuture.completedFuture("message").thenApplyAsync(String::toUpperCase,
	            CompletableFuture.delayedExecutor(1, TimeUnit.SECONDS));

	    CompletableFuture<String> cf2 = cf.exceptionally(throwable -> "cancelled message");

	    System.out.println(cf.cancel(true)); // true
	    System.out.println(cf.isCompletedExceptionally()); // true
	    System.out.println(cf2.join()); // cancelled message
	}

}
