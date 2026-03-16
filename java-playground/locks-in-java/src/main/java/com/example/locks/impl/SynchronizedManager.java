package com.example.locks.impl;

import com.example.locks.BalanceManager;

public class SynchronizedManager implements BalanceManager {
    private double balance = 0;

    @Override
    public synchronized void deposit(double amount) {
        balance += amount;
    }

    @Override
    public synchronized void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        }
    }

    @Override
    public synchronized double getBalance() {
        return balance;
    }

    @Override
    public String getStrategyName() {
        return "Object Lock (Synchronized)";
    }
}
