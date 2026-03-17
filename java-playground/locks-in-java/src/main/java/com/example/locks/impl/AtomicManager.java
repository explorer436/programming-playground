package com.example.locks.impl;

import com.example.locks.BalanceManager;
import java.util.concurrent.atomic.AtomicLong;

public class AtomicManager implements BalanceManager {
    // We use cents to represent the balance to avoid precision issues with double
    // while using atomic operations.
    private final AtomicLong balanceCents = new AtomicLong(0);

    @Override
    public void deposit(double amount) {
        long amountCents = (long) (amount * 100);
        // Lock-free atomic addition
        balanceCents.addAndGet(amountCents);
    }

    @Override
    public void withdraw(double amount) {
        long amountCents = (long) (amount * 100);
        long current;
        long updated;
        
        // Lock-free Compare-And-Swap (CAS) loop
        do {
            current = balanceCents.get();
            if (current < amountCents) {
                return; // Insufficient funds, break out
            }
            updated = current - amountCents;
            // The CPU tries to update the value. If another thread changed it,
            // compareAndSet returns false, and we retry the loop immediately.
        } while (!balanceCents.compareAndSet(current, updated));
    }

    @Override
    public double getBalance() {
        return balanceCents.get() / 100.0;
    }

    @Override
    public String getStrategyName() {
        return "Atomic Variables (CAS / Lock-Free)";
    }
}
