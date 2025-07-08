package com.my.company.launchingcallableusingexecutorservice;

import org.springframework.stereotype.Service;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Service
public class LaunchingCallableUsingExecutorService implements Callable<Integer> {

    int number;

    // factorial method
    public Integer call() throws Exception {
    	System.out.println(">>> LaunchingCallableUsingExecutorService.call()");
    	
    	if(number < 0) {
            throw new Exception("Number should be positive");
        }
    	
        int fact = 1;
        // ...
        for(int count = number; count > 1; count--) {
            fact = fact * count;
        }

        
        System.out.println("<<< LaunchingCallableUsingExecutorService.call()");
        return fact;
    }

    public void setNumber(int number) {
        this.number = number;
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
// 	at com.example.launchingcallableusingexecutorservice.LaunchingCallableUsingExecutorService.main(LaunchingCallableUsingExecutorService.java:50)
// Caused by: java.lang.Exception: Number should be positive
// 	at com.example.launchingcallableusingexecutorservice.LaunchingCallableUsingExecutorService.call(LaunchingCallableUsingExecutorService.java:24)
// 	at com.example.launchingcallableusingexecutorservice.LaunchingCallableUsingExecutorService.call(LaunchingCallableUsingExecutorService.java:1)
// 	at java.base/java.util.concurrent.FutureTask.run(FutureTask.java:264)
// 	at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1136)
// 	at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:635)
// 	at java.base/java.lang.Thread.run(Thread.java:833)
