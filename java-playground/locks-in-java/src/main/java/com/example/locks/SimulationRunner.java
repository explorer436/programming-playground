package com.example.locks;

import com.example.locks.impl.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SimulationRunner {
    private static final int NUM_THREADS = 10;
    private static final int NUM_TRANSACTIONS = 1000;
    private static final double TRANSACTION_AMOUNT = 10.0;

    public static void main(String[] args) throws InterruptedException {
        List<BalanceManager> managers = new ArrayList<>();
        managers.add(new SynchronizedManager());
        managers.add(new ClassLockManager());
        managers.add(new ReentrantLockManager());
        managers.add(new ReadWriteLockManager());
        managers.add(new OptimisticLockManager());

        for (BalanceManager manager : managers) {
            runSimulation(manager);
        }
    }

    private static void runSimulation(BalanceManager manager) throws InterruptedException {
        System.out.println("--------------------------------------------------");
        System.out.println("Starting Simulation: " + manager.getStrategyName());
        
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        long startTime = System.nanoTime();

        for (int i = 0; i < NUM_THREADS; i++) {
            executor.submit(() -> {
                for (int j = 0; j < NUM_TRANSACTIONS; j++) {
                    manager.deposit(TRANSACTION_AMOUNT);
                    // Simulate some work
                    try { Thread.sleep(0, 100); } catch (InterruptedException e) {}
                    manager.withdraw(TRANSACTION_AMOUNT);
                }
            });
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
        
        long endTime = System.nanoTime();
        double durationMs = (endTime - startTime) / 1_000_000.0;

        System.out.println("Final Balance: " + manager.getBalance());
        System.out.println("Duration: " + durationMs + " ms");
        System.out.println("Throughput: " + (NUM_THREADS * NUM_TRANSACTIONS / (durationMs / 1000.0)) + " trans/sec");
    }
}
