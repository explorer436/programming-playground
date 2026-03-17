package com.example.locks;

public class LockDifferenceDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("==================================================");
        System.out.println("      Object Lock vs Class Lock Demonstration     ");
        System.out.println("==================================================\n");
        
        System.out.println("1. Demonstrating Object (Instance) Locks:");
        System.out.println("   -> Two threads accessing the SAME instance will block each other.");
        System.out.println("   -> Two threads accessing DIFFERENT instances will NOT block each other.\n");
        
        ObjectLockDemo instance1 = new ObjectLockDemo("Instance 1");
        ObjectLockDemo instance2 = new ObjectLockDemo("Instance 2");

        // Two threads accessing the same instance
        Thread t1 = new Thread(() -> instance1.syncMethod(), "Thread-1 (Inst 1)");
        Thread t2 = new Thread(() -> instance1.syncMethod(), "Thread-2 (Inst 1)");
        
        // A thread accessing a different instance concurrently
        Thread t3 = new Thread(() -> instance2.syncMethod(), "Thread-3 (Inst 2)");

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("\n--------------------------------------------------");
        System.out.println("\n2. Demonstrating Class Locks:");
        System.out.println("   -> A static synchronized method locks the entire Class metadata.");
        System.out.println("   -> Even if threads access DIFFERENT instances, they will block each other!\n");
        
        ClassLockDemo cInstance1 = new ClassLockDemo("Instance 1");
        ClassLockDemo cInstance2 = new ClassLockDemo("Instance 2");

        Thread t4 = new Thread(() -> cInstance1.staticSyncMethod(), "Thread-4 (Inst 1)");
        Thread t5 = new Thread(() -> cInstance2.staticSyncMethod(), "Thread-5 (Inst 2)");

        t4.start();
        t5.start();
        
        t4.join();
        t5.join();
        
        System.out.println("\nDemo Finished.");
    }

    // --- Demo Classes ---

    static class ObjectLockDemo {
        private String name;

        public ObjectLockDemo(String name) {
            this.name = name;
        }

        // Locks 'this' specific object instance
        public synchronized void syncMethod() {
            System.out.println("   [" + Thread.currentThread().getName() + "] acquired Object Lock for " + name);
            try {
                Thread.sleep(1500); // Simulate work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("   [" + Thread.currentThread().getName() + "] releasing Object Lock for " + name);
        }
    }

    static class ClassLockDemo {
        private String name;

        public ClassLockDemo(String name) {
            this.name = name;
        }

        // Locks the ClassLockDemo.class, affecting all instances
        public static synchronized void staticSyncMethod() {
            System.out.println("   [" + Thread.currentThread().getName() + "] acquired Class Lock");
            try {
                Thread.sleep(1500); // Simulate work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("   [" + Thread.currentThread().getName() + "] releasing Class Lock");
        }
    }
}
