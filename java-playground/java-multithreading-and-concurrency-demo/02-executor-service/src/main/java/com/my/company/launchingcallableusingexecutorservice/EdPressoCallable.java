package com.my.company.launchingcallableusingexecutorservice;

import org.springframework.stereotype.Service;

import java.util.concurrent.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
//class implementing callable interface
public class EdPressoCallable implements Callable<String> {

        // overriding call() method
	@Override
	public String call() throws Exception {
		
		Thread.sleep(500);
		
		// return the thread name executing this callable task
		return Thread.currentThread().getName();
	}
}

// The code in call() is executed before the main() method completes its execution. 

// Output:
// Hello from a thread! - date: Mon Sep 26 00:34:40 EDT 2022:: Thread name is pool-1-thread-1
// Hello from a thread! - date: Mon Sep 26 00:34:40 EDT 2022:: Thread name is pool-1-thread-2
// Hello from a thread! - date: Mon Sep 26 00:34:40 EDT 2022:: Thread name is pool-1-thread-3
// Hello from a thread! - date: Mon Sep 26 00:34:40 EDT 2022:: Thread name is pool-1-thread-4
// Hello from a thread! - date: Mon Sep 26 00:34:40 EDT 2022:: Thread name is pool-1-thread-5
// Hello from a thread! - date: Mon Sep 26 00:34:40 EDT 2022:: Thread name is pool-1-thread-4
// Hello from a thread! - date: Mon Sep 26 00:34:41 EDT 2022:: Thread name is pool-1-thread-2
// Hello from a thread! - date: Mon Sep 26 00:34:41 EDT 2022:: Thread name is pool-1-thread-1
// Hello from a thread! - date: Mon Sep 26 00:34:41 EDT 2022:: Thread name is pool-1-thread-3
// Hello from a thread! - date: Mon Sep 26 00:34:41 EDT 2022:: Thread name is pool-1-thread-5
// Hello from a thread! - date: Mon Sep 26 00:34:41 EDT 2022:: Thread name is pool-1-thread-2
// Hello from a thread! - date: Mon Sep 26 00:34:41 EDT 2022:: Thread name is pool-1-thread-4
// Hello from a thread! - date: Mon Sep 26 00:34:41 EDT 2022:: Thread name is pool-1-thread-1
// Hello from a thread! - date: Mon Sep 26 00:34:41 EDT 2022:: Thread name is pool-1-thread-5
// Hello from a thread! - date: Mon Sep 26 00:34:41 EDT 2022:: Thread name is pool-1-thread-3
// Hello from a thread! - date: Mon Sep 26 00:34:41 EDT 2022:: Thread name is pool-1-thread-2
// Hello from a thread! - date: Mon Sep 26 00:34:42 EDT 2022:: Thread name is pool-1-thread-4
// Hello from a thread! - date: Mon Sep 26 00:34:42 EDT 2022:: Thread name is pool-1-thread-1
// Hello from a thread! - date: Mon Sep 26 00:34:42 EDT 2022:: Thread name is pool-1-thread-5
// Hello from a thread! - date: Mon Sep 26 00:34:42 EDT 2022:: Thread name is pool-1-thread-3
// Hello from a thread! - date: Mon Sep 26 00:34:42 EDT 2022:: Thread name is pool-1-thread-1
// Hello from a thread! - date: Mon Sep 26 00:34:42 EDT 2022:: Thread name is pool-1-thread-2
// Hello from a thread! - date: Mon Sep 26 00:34:42 EDT 2022:: Thread name is pool-1-thread-5
// Hello from a thread! - date: Mon Sep 26 00:34:42 EDT 2022:: Thread name is pool-1-thread-3
// Hello from a thread! - date: Mon Sep 26 00:34:42 EDT 2022:: Thread name is pool-1-thread-4
// Hello from a thread! - date: Mon Sep 26 00:34:42 EDT 2022:: Thread name is pool-1-thread-1
// Hello from a thread! - date: Mon Sep 26 00:34:43 EDT 2022:: Thread name is pool-1-thread-5
// Hello from a thread! - date: Mon Sep 26 00:34:43 EDT 2022:: Thread name is pool-1-thread-2
// Hello from a thread! - date: Mon Sep 26 00:34:43 EDT 2022:: Thread name is pool-1-thread-4
// Hello from a thread! - date: Mon Sep 26 00:34:43 EDT 2022:: Thread name is pool-1-thread-3
// Hello from a thread! - date: Mon Sep 26 00:34:43 EDT 2022:: Thread name is pool-1-thread-1
// Hello from a thread! - date: Mon Sep 26 00:34:43 EDT 2022:: Thread name is pool-1-thread-5
// Hello from a thread! - date: Mon Sep 26 00:34:43 EDT 2022:: Thread name is pool-1-thread-2
// Hello from a thread! - date: Mon Sep 26 00:34:43 EDT 2022:: Thread name is pool-1-thread-3
// Hello from a thread! - date: Mon Sep 26 00:34:43 EDT 2022:: Thread name is pool-1-thread-4
// Hello from a thread! - date: Mon Sep 26 00:34:43 EDT 2022:: Thread name is pool-1-thread-5
// Hello from a thread! - date: Mon Sep 26 00:34:44 EDT 2022:: Thread name is pool-1-thread-2
// Hello from a thread! - date: Mon Sep 26 00:34:44 EDT 2022:: Thread name is pool-1-thread-1
// Hello from a thread! - date: Mon Sep 26 00:34:44 EDT 2022:: Thread name is pool-1-thread-3
// Hello from a thread! - date: Mon Sep 26 00:34:44 EDT 2022:: Thread name is pool-1-thread-4
// Hello from a thread! - date: Mon Sep 26 00:34:44 EDT 2022:: Thread name is pool-1-thread-3
// Hello from a thread! - date: Mon Sep 26 00:34:44 EDT 2022:: Thread name is pool-1-thread-1
// Hello from a thread! - date: Mon Sep 26 00:34:44 EDT 2022:: Thread name is pool-1-thread-5
// Hello from a thread! - date: Mon Sep 26 00:34:44 EDT 2022:: Thread name is pool-1-thread-2
// Hello from a thread! - date: Mon Sep 26 00:34:44 EDT 2022:: Thread name is pool-1-thread-4
// Hello from a thread! - date: Mon Sep 26 00:34:44 EDT 2022:: Thread name is pool-1-thread-5
// Hello from a thread! - date: Mon Sep 26 00:34:45 EDT 2022:: Thread name is pool-1-thread-3
// Hello from a thread! - date: Mon Sep 26 00:34:45 EDT 2022:: Thread name is pool-1-thread-1
// Hello from a thread! - date: Mon Sep 26 00:34:45 EDT 2022:: Thread name is pool-1-thread-2
// Hello from a thread! - date: Mon Sep 26 00:34:45 EDT 2022:: Thread name is pool-1-thread-4
// Hello from main
	
