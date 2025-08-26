package com.my.company;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceExample {

    public static void main(String[] args) {

        // Create a fixed-size thread pool with 3 threads
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // Submit 10 tasks to the executor service
        for (int i = 0; i < 10; i++) {
            final int taskId = i;
            // The executor will pick up these tasks and execute them using the available threads
            executorService.submit(() -> {
                System.out.println("Executing Task " + taskId + " on thread: " + Thread.currentThread().getName());
                try {
                    // Simulate work being done
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        // Initiate a shutdown, preventing new tasks from being accepted
        executorService.shutdown();

        // Wait for all tasks to complete before exiting the program
        try {
            // Wait for up to 60 seconds for all tasks to complete
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                System.err.println("Tasks did not terminate in the specified time.");
            }
        } catch (InterruptedException e) {
            System.err.println("Termination was interrupted.");
        }

        System.out.println("All tasks completed.");
    }
}