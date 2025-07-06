package com.my.company.launchingrunnableusingexecutorservice;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestDriver {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        EdPressoRunnable edpressoRunnable = new EdPressoRunnable();

        // You can pass Runnable to create a Thread.
        Thread thread = new Thread(edpressoRunnable);
        thread.start();
        System.out.println("Thread name: " + Thread.currentThread().getName() + ", Thread id: "
                + Thread.currentThread().getId() + ", Output for code outside the thread");

        System.out.println(">>> main()");

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future future = executorService.submit(new LaunchingRunnableUsingExecutorService());
        System.out.println("future value is " + future.get());
        executorService.shutdown();

        System.out.println("<<< main()");
    }
}
