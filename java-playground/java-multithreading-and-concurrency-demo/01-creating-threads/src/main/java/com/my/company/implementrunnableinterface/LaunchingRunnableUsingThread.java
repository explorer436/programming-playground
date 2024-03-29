package com.my.company.implementrunnableinterface;

import java.util.concurrent.ExecutionException;

public class LaunchingRunnableUsingThread implements Runnable {

	@Override
	public void run() {
		System.out.println(">>> run()");
		
		System.out.println("Message");
		
		System.out.println("<<< run()");
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		System.out.println(">>> main()");
		
		(new Thread(new LaunchingRunnableUsingThread())).start();
		
		System.out.println("<<< main()");
	}
}

// Output:
// >>> main()
// >>> run()
// Message
// <<< run()
// future value is null
// <<< main()

//The code in run() is executed after the main() method completes its execution.