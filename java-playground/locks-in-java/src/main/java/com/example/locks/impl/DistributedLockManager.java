package com.example.locks.impl;

import com.example.locks.BalanceManager;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

public class DistributedLockManager implements BalanceManager {
    private double balance = 0;
    private RedissonClient redisson;
    private RLock lock;
    private boolean isRedisAvailable = true;

    public DistributedLockManager() {
        try {
            // Configure Redisson to connect to a local Redis server
            Config config = new Config();
            config.useSingleServer()
                  .setAddress("redis://127.0.0.1:6379")
                  .setTimeout(1000)
                  .setConnectTimeout(1000)
                  .setRetryAttempts(1); // Fast failure if Redis is missing
                  
            redisson = Redisson.create(config);
            // This lock is globally shared across any server connecting to this Redis instance
            lock = redisson.getLock("global_bank_account_lock");
        } catch (Exception e) {
            System.err.println("  [Warning] Redis is not available at 127.0.0.1:6379.");
            System.err.println("  [Warning] DistributedLockManager operations will be skipped.");
            isRedisAvailable = false;
        }
    }

    @Override
    public void deposit(double amount) {
        if (!isRedisAvailable) return;
        lock.lock();
        try {
            balance += amount;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void withdraw(double amount) {
        if (!isRedisAvailable) return;
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
        if (!isRedisAvailable) return balance;
        lock.lock();
        try {
            return balance;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public String getStrategyName() {
        return "Distributed Lock (Redisson)";
    }
    
    // Helper to gracefully shut down the Redis client
    public void shutdown() {
        if (redisson != null) {
            redisson.shutdown();
        }
    }
}
