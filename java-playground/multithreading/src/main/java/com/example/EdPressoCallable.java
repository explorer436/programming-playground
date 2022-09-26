package com.example;

import java.util.concurrent.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//class implementing callable interface
public class EdPressoCallable implements Callable<String> {

	@Override // overriding method
	public String call() throws Exception {
		
		Thread.sleep(500);
		
		// return the thread name executing this callable task
		return Thread.currentThread().getName();
	}

	// main method starting here
	public static void main(String args[]) {
		
		// Thread pool size is 5
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		
		// Create EdPresso instance
		Callable<String> callable = new EdPressoCallable();
		
		// create a list to hold the Future object associated with Callable
		List<Future<String>> mylistOfFutures = new ArrayList<Future<String>>();
		
		for (int i = 0; i < 50; i++) {
			// submit 50 Callable tasks to be executed by thread pool
			Future<String> fut = executorService.submit(callable);
			// add Future to the list, we can get return value using Future
			mylistOfFutures.add(fut);
		}
		
		for (Future<String> f : mylistOfFutures) {
			try {
				// because Future.get() waits for task to get completed
				System.out.println("Hello from a thread! - date: " + new Date() + ":: Thread name is " + f.get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		
		// shut down the executor service now
		executorService.shutdown();
		
		System.out.println("Hello from main");
	}
}

// The code in run() is executed before the main() method completes its execution. 

// Output:
// Hello from a thread! - date: Mon Sep 26 00:34:40 EDT 2022:: Thread name is pool-1-thread-1
// Hello from a thread! - date: Mon Sep 26 00:34:40 EDT 2022:: Thread name is pool-1-thread-2
// Hello from a thread! - date: Mon Sep 26 00:34:40 EDT 2022:: Thread name is pool-1-thread-3
// Hello from a thread! - date: Mon Sep 26 00:34:40 EDT 2022:: Thread name is pool-1-thread-4
// Hello from a thread! - date: Mon Sep 26 00:34:40 EDT 2022:: Thread name is pool-1-thread-5
// Hello from a thread! - date: Mon Sep 26 00:34:40 EDT 2022:: Thread name is pool-1-thread-4
// Hello from a thread! - date: Mon Sep 26 00:34:41 EDT 2022:: Thread name is pool-1-thread-2
// Hello from a thread! - date: Mon Sep 26 00:34:41 EDT 2022:: Thread name is pool-1-thread-1
// Hello from a thread! - date: Mon Sep 26 00:34:41 EDT 2022:: Thread name is pool-1-thread-3
// Hello from a thread! - date: Mon Sep 26 00:34:41 EDT 2022:: Thread name is pool-1-thread-5
// Hello from a thread! - date: Mon Sep 26 00:34:41 EDT 2022:: Thread name is pool-1-thread-2
// Hello from a thread! - date: Mon Sep 26 00:34:41 EDT 2022:: Thread name is pool-1-thread-4
// Hello from a thread! - date: Mon Sep 26 00:34:41 EDT 2022:: Thread name is pool-1-thread-1
// Hello from a thread! - date: Mon Sep 26 00:34:41 EDT 2022:: Thread name is pool-1-thread-5
// Hello from a thread! - date: Mon Sep 26 00:34:41 EDT 2022:: Thread name is pool-1-thread-3
// Hello from a thread! - date: Mon Sep 26 00:34:41 EDT 2022:: Thread name is pool-1-thread-2
// Hello from a thread! - date: Mon Sep 26 00:34:42 EDT 2022:: Thread name is pool-1-thread-4
// Hello from a thread! - date: Mon Sep 26 00:34:42 EDT 2022:: Thread name is pool-1-thread-1
// Hello from a thread! - date: Mon Sep 26 00:34:42 EDT 2022:: Thread name is pool-1-thread-5
// Hello from a thread! - date: Mon Sep 26 00:34:42 EDT 2022:: Thread name is pool-1-thread-3
// Hello from a thread! - date: Mon Sep 26 00:34:42 EDT 2022:: Thread name is pool-1-thread-1
// Hello from a thread! - date: Mon Sep 26 00:34:42 EDT 2022:: Thread name is pool-1-thread-2
// Hello from a thread! - date: Mon Sep 26 00:34:42 EDT 2022:: Thread name is pool-1-thread-5
// Hello from a thread! - date: Mon Sep 26 00:34:42 EDT 2022:: Thread name is pool-1-thread-3
// Hello from a thread! - date: Mon Sep 26 00:34:42 EDT 2022:: Thread name is pool-1-thread-4
// Hello from a thread! - date: Mon Sep 26 00:34:42 EDT 2022:: Thread name is pool-1-thread-1
// Hello from a thread! - date: Mon Sep 26 00:34:43 EDT 2022:: Thread name is pool-1-thread-5
// Hello from a thread! - date: Mon Sep 26 00:34:43 EDT 2022:: Thread name is pool-1-thread-2
// Hello from a thread! - date: Mon Sep 26 00:34:43 EDT 2022:: Thread name is pool-1-thread-4
// Hello from a thread! - date: Mon Sep 26 00:34:43 EDT 2022:: Thread name is pool-1-thread-3
// Hello from a thread! - date: Mon Sep 26 00:34:43 EDT 2022:: Thread name is pool-1-thread-1
// Hello from a thread! - date: Mon Sep 26 00:34:43 EDT 2022:: Thread name is pool-1-thread-5
// Hello from a thread! - date: Mon Sep 26 00:34:43 EDT 2022:: Thread name is pool-1-thread-2
// Hello from a thread! - date: Mon Sep 26 00:34:43 EDT 2022:: Thread name is pool-1-thread-3
// Hello from a thread! - date: Mon Sep 26 00:34:43 EDT 2022:: Thread name is pool-1-thread-4
// Hello from a thread! - date: Mon Sep 26 00:34:43 EDT 2022:: Thread name is pool-1-thread-5
// Hello from a thread! - date: Mon Sep 26 00:34:44 EDT 2022:: Thread name is pool-1-thread-2
// Hello from a thread! - date: Mon Sep 26 00:34:44 EDT 2022:: Thread name is pool-1-thread-1
// Hello from a thread! - date: Mon Sep 26 00:34:44 EDT 2022:: Thread name is pool-1-thread-3
// Hello from a thread! - date: Mon Sep 26 00:34:44 EDT 2022:: Thread name is pool-1-thread-4
// Hello from a thread! - date: Mon Sep 26 00:34:44 EDT 2022:: Thread name is pool-1-thread-3
// Hello from a thread! - date: Mon Sep 26 00:34:44 EDT 2022:: Thread name is pool-1-thread-1
// Hello from a thread! - date: Mon Sep 26 00:34:44 EDT 2022:: Thread name is pool-1-thread-5
// Hello from a thread! - date: Mon Sep 26 00:34:44 EDT 2022:: Thread name is pool-1-thread-2
// Hello from a thread! - date: Mon Sep 26 00:34:44 EDT 2022:: Thread name is pool-1-thread-4
// Hello from a thread! - date: Mon Sep 26 00:34:44 EDT 2022:: Thread name is pool-1-thread-5
// Hello from a thread! - date: Mon Sep 26 00:34:45 EDT 2022:: Thread name is pool-1-thread-3
// Hello from a thread! - date: Mon Sep 26 00:34:45 EDT 2022:: Thread name is pool-1-thread-1
// Hello from a thread! - date: Mon Sep 26 00:34:45 EDT 2022:: Thread name is pool-1-thread-2
// Hello from a thread! - date: Mon Sep 26 00:34:45 EDT 2022:: Thread name is pool-1-thread-4
// Hello from main
	
