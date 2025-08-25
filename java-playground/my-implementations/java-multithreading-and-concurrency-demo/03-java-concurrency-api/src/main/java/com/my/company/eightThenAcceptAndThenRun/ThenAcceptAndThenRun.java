package com.my.company.eightThenAcceptAndThenRun;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;
import java.util.function.Function;

public class ThenAcceptAndThenRun {

	private CompletableFuture<String> calculateHelloAsync() throws InterruptedException {
		return CompletableFuture.supplyAsync(() -> "Hello");
	}

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ThenAcceptAndThenRun classUnderTest = new ThenAcceptAndThenRun();

        CompletableFuture<Void> future02 = classUnderTest.calculateHelloAsync().thenAccept(writeTheResultToLogs());
        future02.get(); // The type of this is "Void".
        // Computation returned: Hello

        CompletableFuture<Void> future03 = classUnderTest.calculateHelloAsync().thenRun(runARunnable());
        future03.get(); // The type of this is "Void".
        // Computation finished.
    }

    private static Runnable runARunnable() {
        return () -> System.out.println("Computation finished.");
    }

    private static Consumer<String> writeTheResultToLogs() {
        return s -> System.out.println("Computation returned: " + s);
    }
}
