package com.example.locks.impl;

import com.example.locks.BalanceManager;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockManager implements BalanceManager {
    private double balance = 0;
    private final Lock lock = new ReentrantLock();

    @Override
    public void deposit(double amount) {
        lock.lock();
        try {
            balance += amount;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void withdraw(double amount) {
        lock.lock();
        try {
            if (balance >= amount) {
                balance -= amount;
            }
        } finally {
            lock.unlock();
        }
    }

    @Override
    public double getBalance() {
        lock.lock();
        try {
            return balance;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public String getStrategyName() {
        return "ReentrantLock (Pessimistic)";
    }
}
