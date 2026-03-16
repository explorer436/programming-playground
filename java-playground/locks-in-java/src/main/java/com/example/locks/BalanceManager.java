package com.example.locks;

public interface BalanceManager {
    void deposit(double amount);
    void withdraw(double amount);
    double getBalance();
    String getStrategyName();
}
