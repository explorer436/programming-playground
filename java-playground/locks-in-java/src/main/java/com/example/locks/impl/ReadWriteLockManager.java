package com.example.locks.impl;

import com.example.locks.BalanceManager;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockManager implements BalanceManager {
    private double balance = 0;
    private final ReadWriteLock rwLock = new ReentrantReadWriteLock();

    @Override
    public void deposit(double amount) {
        rwLock.writeLock().lock();
        try {
            balance += amount;
        } finally {
            rwLock.writeLock().unlock();
        }
    }

    @Override
    public void withdraw(double amount) {
        rwLock.writeLock().lock();
        try {
            if (balance >= amount) {
                balance -= amount;
            }
        } finally {
            rwLock.writeLock().unlock();
        }
    }

    @Override
    public double getBalance() {
        rwLock.readLock().lock();
        try {
            return balance;
        } finally {
            rwLock.readLock().unlock();
        }
    }

    @Override
    public String getStrategyName() {
        return "ReadWriteLock";
    }
}
