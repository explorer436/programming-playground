package com.my.company.launchingthreadusingexecutorservice;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
@Setter
public class ImplementThreadByExtendingThreadClass extends Thread {

	String message;

	@Override
	public void run() {
		System.out.println("message: " + message);
	}

}

// Output:

// message: SimpleThread executed using Thread
// message: SimpleThread executed using ExecutorService
