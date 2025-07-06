package com.my.company.receiver;

import com.my.company.model.Data;

import java.util.concurrent.ThreadLocalRandom;

public class Receiver implements Runnable {

    private final Data load;


    public Receiver(Data load) {
        this.load = load;
    }

    @Override
    public void run() {
        for (String receivedMessage = load.receive();
             !"End".equals(receivedMessage);
             receivedMessage = load.receive()) {

            System.out.println("received : " + receivedMessage);

            //Thread.sleep() to mimic heavy server-side processing
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread Interrupted");
            }
        }
    }
}
