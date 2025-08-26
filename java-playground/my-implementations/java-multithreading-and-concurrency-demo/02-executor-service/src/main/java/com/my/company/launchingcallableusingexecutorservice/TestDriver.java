package com.my.company.launchingcallableusingexecutorservice;

import com.my.company.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class TestDriver {

    // main method starting here
    public static void main(String args[]) throws ExecutionException, InterruptedException {

        System.out.println("starting main...");

        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        EdPressoCallable edPressoCallable = ctx.getBean(EdPressoCallable.class);
        // myService.doStuff();

        // Thread pool size is 5
        ExecutorService executorService_ThreadPool = Executors.newFixedThreadPool(5);

        // Create EdPresso instance
        Callable<String> callableInstance = edPressoCallable;

        // create a list to hold the Future objects associated with Callables
        List<Future<String>> myListOfFutures = new ArrayList<Future<String>>();

        for (int i = 0; i < 50; i++) {
            // submit 50 Callable tasks to be executed by thread pool
            Future<String> futures = executorService_ThreadPool.submit(callableInstance);
            // add Future to the list, we can get return value using Future
            myListOfFutures.add(futures);
        }

        for (Future<String> f : myListOfFutures) {
            try {
                // because Future.get() waits for task to get completed
                System.out.println("Hello from a thread! - date: " + new Date() + ":: Thread name is " + f.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        // shut down the executor service now
        executorService_ThreadPool.shutdown();

        System.out.println("ending main...");

        System.out.println(">>> main");

        ExecutorService executorService_SingleThread = Executors.newSingleThreadExecutor();

        LaunchingCallableUsingExecutorService task1 = ctx.getBean(LaunchingCallableUsingExecutorService.class);
        task1.setNumber(5);
        Future<Integer> future1 = executorService_SingleThread.submit(task1);
        System.out.println("future1.get() : " + future1.get());

        // In case of running a Callable using an ExecutorService,
        // the exceptions are collected in the Future object.
        // We can check this by making a call to the Future.get() method.

        /*LaunchingCallableUsingExecutorService task2 = ctx.getBean(LaunchingCallableUsingExecutorService.class);
        task2.setNumber(-5);
        Future<Integer> future2 = executorService_SingleThread.submit(task2);
        System.out.println("future2.get() : " + future2.get());*/

        System.out.println("<<< main");
    }
}
