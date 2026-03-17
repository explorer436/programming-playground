package com.example.locks.impl;

import com.example.locks.BalanceManager;
import java.util.concurrent.Semaphore;

public class SemaphoreManager implements BalanceManager {
    private double balance = 0;
    // A semaphore initialized with 1 permit acts as a Mutex (Mutual Exclusion lock)
    private final Semaphore semaphore = new Semaphore(1);

    @Override
    public void deposit(double amount) {
        try {
            semaphore.acquire(); // Request the permit
            balance += amount;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            semaphore.release(); // Return the permit
        }
    }

    @Override
    public void withdraw(double amount) {
        try {
            semaphore.acquire();
            if (balance >= amount) {
                balance -= amount;
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            semaphore.release();
        }
    }

    @Override
    public double getBalance() {
        try {
            semaphore.acquire();
            return balance;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return 0;
        } finally {
            semaphore.release();
        }
    }

    @Override
    public String getStrategyName() {
        return "Semaphore (1 Permit / Mutex)";
    }
}
