package com.example;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class LaunchingCallableUsingExecutorService implements Callable<Integer> {
    int number;

    // standard constructors
    public LaunchingCallableUsingExecutorService(int number) {
		super();
		this.number = number;
	}
    

    // factorial method
    public Integer call() throws Exception {
    	System.out.println(">>> call()");
    	
    	if(number < 0) {
            throw new Exception("Number should be positive");
        }
    	
        int fact = 1;
        // ...
        for(int count = number; count > 1; count--) {
            fact = fact * count;
        }

        
        System.out.println("<<< call()");
        return fact;
    }

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		System.out.println(">>> main");
		
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		
    	LaunchingCallableUsingExecutorService task1 = new LaunchingCallableUsingExecutorService(5);
        Future<Integer> future1 = executorService.submit(task1);
        System.out.println("future1.get() : " + future1.get());
        
        // In case of running a Callable using an ExecutorService, the exceptions are collected in the Future object. We can check this by making a call to the Future.get() method.
        LaunchingCallableUsingExecutorService task2 = new LaunchingCallableUsingExecutorService(-5);
        Future<Integer> future2 = executorService.submit(task2);
        System.out.println("future2.get() : " + future2.get());
        
        System.out.println("<<< main");
	}
}

// The code in call() is executed before the main() method completes its execution.

// >>> main
// >>> call()
// <<< call()
// future1.get() : 120
// >>> call()
// Exception in thread "main" java.util.concurrent.ExecutionException: java.lang.Exception: Number should be positive
// 	at java.base/java.util.concurrent.FutureTask.report(FutureTask.java:122)
// 	at java.base/java.util.concurrent.FutureTask.get(FutureTask.java:191)
// 	at com.example.LaunchingCallableUsingExecutorService.main(LaunchingCallableUsingExecutorService.java:50)
// Caused by: java.lang.Exception: Number should be positive
// 	at com.example.LaunchingCallableUsingExecutorService.call(LaunchingCallableUsingExecutorService.java:24)
// 	at com.example.LaunchingCallableUsingExecutorService.call(LaunchingCallableUsingExecutorService.java:1)
// 	at java.base/java.util.concurrent.FutureTask.run(FutureTask.java:264)
// 	at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1136)
// 	at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:635)
// 	at java.base/java.lang.Thread.run(Thread.java:833)
