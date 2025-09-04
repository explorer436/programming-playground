package com.my.company.strings;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

class FizzBuzzMultithreaded {

    private int n;
    private Semaphore fizzSemaphore = new Semaphore(0);
    private Semaphore buzzSemaphore = new Semaphore(0);
    private Semaphore fizzbuzzSemaphore = new Semaphore(0);
    private Semaphore numberSemaphore = new Semaphore(1); // Start with number thread allowed

    public FizzBuzzMultithreaded(int n) {
        this.n = n;
    }

    // printFizz() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 != 0) {
                fizzSemaphore.acquire();
                printFizz.run();
                numberSemaphore.release();
            }
        }
    }

    // printBuzz() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 5 == 0 && i % 3 != 0) {
                buzzSemaphore.acquire();
                printBuzz.run();
                numberSemaphore.release();
            }
        }
    }

    // printFizzBuzz() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                fizzbuzzSemaphore.acquire();
                printFizzBuzz.run();
                numberSemaphore.release();
            }
        }
    }

    // printNumber(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            numberSemaphore.acquire();
            if (i % 15 == 0) {
                fizzbuzzSemaphore.release();
            } else if (i % 3 == 0) {
                fizzSemaphore.release();
            } else if (i % 5 == 0) {
                buzzSemaphore.release();
            } else {
                printNumber.accept(i);
                numberSemaphore.release(); // Release for the next number if no special case
            }
        }
    }

    public static void main(String[] args) {
        int n = 15; // Example: print FizzBuzz up to 15
        FizzBuzzMultithreaded fb = new FizzBuzzMultithreaded(n);

        // Create and start threads
        new Thread(() -> {
            try {
                fb.fizz(() -> System.out.print("fizz "));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();

        new Thread(() -> {
            try {
                fb.buzz(() -> System.out.print("buzz "));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();

        new Thread(() -> {
            try {
                fb.fizzbuzz(() -> System.out.print("fizzbuzz "));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();

        new Thread(() -> {
            try {
                fb.number(x -> System.out.print(x + " "));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();
    }
}


