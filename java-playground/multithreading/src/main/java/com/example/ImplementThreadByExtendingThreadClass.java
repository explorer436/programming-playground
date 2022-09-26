package com.example;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ImplementThreadByExtendingThreadClass extends Thread {

	private String message;

	// standard logger, constructor
	public ImplementThreadByExtendingThreadClass(String message) {
		super();
		this.message = message;
	}

	@Override
	public void run() {
		System.out.println("message: " + message);
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		// first method of running a thread of this type

		Thread thread = new ImplementThreadByExtendingThreadClass("SimpleThread executed using Thread");
		thread.start();
		thread.join();

		// second method of running a thread of this type
		
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		executorService.submit(new ImplementThreadByExtendingThreadClass(
			      "SimpleThread executed using ExecutorService")).get();
	}
}

// Output:

// message: SimpleThread executed using Thread
// message: SimpleThread executed using ExecutorService
