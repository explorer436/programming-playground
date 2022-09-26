package com.example;

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

		Instant endInstant = java.time.Instant.now();
		Duration between = java.time.Duration.between(startInstant, endInstant);
		System.out.format("Time taken : %02d:%02d.%04d \n", between.toMinutes(), between.getSeconds(),
				between.toMillis());

		System.out.println("Main Thread completed...");
	}

	public static void runnableThreads() throws InterruptedException, ExecutionException {
		ExecutorService executor = Executors.newFixedThreadPool(4);
		Future<?> f1 = executor.submit(new RunnableTask(5));
		Future<?> f2 = executor.submit(new RunnableTask(2));
		Future<?> f3 = executor.submit(new RunnableTask(1));

		// Waits until pool-thread complete, return null upon successful completion.
		System.out.println("runnableThreads - F1 : " + f1.get());
		System.out.println("runnableThreads - F2 : " + f2.get());
		System.out.println("runnableThreads - F3 : " + f3.get());

		executor.shutdown();
	}

	public static void callableThreads() throws InterruptedException, ExecutionException {
		ExecutorService executor = Executors.newFixedThreadPool(4);
		Future<Integer> f1 = executor.submit(new CallableTask(5));
		Future<Integer> f2 = executor.submit(new CallableTask(2));
		Future<Integer> f3 = executor.submit(new CallableTask(1));

		// Waits until pool-thread complete, returns the result.
		System.out.println("callableThreads - F1 : " + f1.get());
		System.out.println("callableThreads - F2 : " + f2.get());
		System.out.println("callableThreads - F3 : " + f3.get());

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
		System.out.println(threadName + " : Started Task...");

		for (int i = 0; i < 5; i++) {
			System.out.println(i + " : " + threadName + " : " + num);
			num = num + i;
			Thread.sleep(1);
		}
		System.out.println(threadName + " : Completed Task. Final Value : " + num);

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
		System.out.println(threadName + " : Started Task...");

		for (int i = 0; i < 5; i++) {
			System.out.println(i + " : " + threadName + " : " + num);
			num = num + i;
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(threadName + " : Completed Task. Final Value : " + num);
	}
}