package com.example;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class LaunchingRunnableUsingExecutorService implements Runnable {

	@Override
	public void run() {
		System.out.println(">>> run()");
		
		System.out.println("Message");
		
		System.out.println("<<< run()");
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		System.out.println(">>> main()");
		
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		Future future = executorService.submit(new LaunchingRunnableUsingExecutorService());
		System.out.println("future value is " + future.get());
		executorService.shutdown();
		
		System.out.println("<<< main()");
	}
}

// Output:
// >>> main()
// >>> run()
// Message
// <<< run()
// future value is null
// <<< main()

//The code in run() is executed after the main() method completes its execution.