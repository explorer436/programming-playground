package com.my.company.launchingthreadusingexecutorservice;

import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class ImplementThreadByExtendingThreadClass extends Thread {

	String message;

	@Override
	public void run() {
		System.out.println("message: " + message);
	}

	public void setMessage(String message) {
		this.message = message;
	}
}

// Output:

// message: SimpleThread executed using Thread
// message: SimpleThread executed using ExecutorService
