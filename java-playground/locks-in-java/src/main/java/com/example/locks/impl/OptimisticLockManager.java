package com.example.locks.impl;

import com.example.locks.BalanceManager;
import java.util.concurrent.locks.StampedLock;

public class OptimisticLockManager implements BalanceManager {
    private double balance = 0;
    private final StampedLock lock = new StampedLock();

    @Override
    public void deposit(double amount) {
        long stamp = lock.writeLock();
        try {
            balance += amount;
        } finally {
            lock.unlockWrite(stamp);
        }
    }

    @Override
    public void withdraw(double amount) {
        long stamp = lock.writeLock();
        try {
            if (balance >= amount) {
                balance -= amount;
            }
        } finally {
            lock.unlockWrite(stamp);
        }
    }

    @Override
    public double getBalance() {
        long stamp = lock.tryOptimisticRead();
        double currentBalance = balance;
        if (!lock.validate(stamp)) {
            stamp = lock.readLock();
            try {
                currentBalance = balance;
            } finally {
                lock.unlockRead(stamp);
            }
        }
        return currentBalance;
    }

    @Override
    public String getStrategyName() {
        return "StampedLock (Optimistic Read)";
    }
}
