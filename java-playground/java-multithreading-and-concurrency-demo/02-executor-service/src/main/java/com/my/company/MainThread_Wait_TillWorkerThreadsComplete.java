package com.my.company;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MainThread_Wait_TillWorkerThreadsComplete {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		System.out.println("Main Thread start...");
		Instant startInstant= java.time.Instant.now();

		runnableThreads();
		callableThreads();
		
		System.out.println("");
		System.out.println("");

		Instant endInstant = java.time.Instant.now();
		Duration between = java.time.Duration.between(startInstant, endInstant);
		System.out.format("Time taken : %02d:%02d.%04d \n", between.toMinutes(), between.getSeconds(),
				between.toMillis());

		System.out.println("Main Thread completed...");
	}

	public static void runnableThreads() throws InterruptedException, ExecutionException {
		
		System.out.println("");
		System.out.println("");
		
		ExecutorService executor = Executors.newFixedThreadPool(4);
		Future<?> f1 = executor.submit(new RunnableTask(5));
		Future<?> f2 = executor.submit(new RunnableTask(2));
		Future<?> f3 = executor.submit(new RunnableTask(1));

		// Waits until pool-thread complete, return null upon successful completion.
		System.out.println("Return value from runnableThread - F1 is : " + f1.get());
		System.out.println("Return value from runnableThread - F2 is : " + f2.get());
		System.out.println("Return value from runnableThread - F3 is : " + f3.get());

		executor.shutdown();
	}

	public static void callableThreads() throws InterruptedException, ExecutionException {
		
		System.out.println("");
		System.out.println("");
		
		ExecutorService executor = Executors.newFixedThreadPool(4);
		Future<Integer> f1 = executor.submit(new CallableTask(5));
		Future<Integer> f2 = executor.submit(new CallableTask(2));
		Future<Integer> f3 = executor.submit(new CallableTask(1));

		// Waits until pool-thread complete, returns the result.
		System.out.println("Return value from callableThread - F1 is : " + f1.get());
		System.out.println("Return value from callableThread - F2 is : " + f2.get());
		System.out.println("Return value from callableThread - F3 is : " + f3.get());

		executor.shutdown();
	}
}

class CallableTask implements Callable<Integer> {
	private int num = 0;

	public CallableTask(int num) {
		this.num = num;
	}

	@Override
	public Integer call() throws Exception {
		String threadName = Thread.currentThread().getName();
		System.out.println("Started Callable Task... threadName is " + threadName);

		for (int i = 0; i < 5; i++) {
			System.out.println("Looping in CallableTask for" + i + "th time with threadName : " + threadName + " : " + num);
			num = num + i;
			Thread.sleep(1);
		}
		System.out.println("Completed Callable Task... threadName is " + threadName + ", Final Value of num is : " + num);

		return num;
	}
}

class RunnableTask implements Runnable {
	private int num = 0;

	public RunnableTask(int num) {
		this.num = num;
	}

	@Override
	public void run() {
		String threadName = Thread.currentThread().getName();
		System.out.println("Started Runnable Task... threadName is " + threadName);

		for (int i = 0; i < 5; i++) {
			System.out.println("Looping in RunnableTask for" + i + "th time with threadName : " + threadName + " : " + num);
			num = num + i;
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Completed Runnable Task... threadName is " + threadName + ", Final Value of num is : " + num);
	}
}