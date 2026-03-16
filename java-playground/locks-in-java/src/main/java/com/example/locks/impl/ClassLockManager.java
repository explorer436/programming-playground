package com.example.locks.impl;

import com.example.locks.BalanceManager;

public class ClassLockManager implements BalanceManager {
    private static double balance = 0;

    @Override
    public void deposit(double amount) {
        synchronized (ClassLockManager.class) {
            balance += amount;
        }
    }

    @Override
    public void withdraw(double amount) {
        synchronized (ClassLockManager.class) {
            if (balance >= amount) {
                balance -= amount;
            }
        }
    }

    @Override
    public double getBalance() {
        synchronized (ClassLockManager.class) {
            return balance;
        }
    }

    @Override
    public String getStrategyName() {
        return "Class Lock (Static Synchronized)";
    }
}
