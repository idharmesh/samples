/**
 * 
 */
package com.mo.prep.interview.concurrency.threads;

import java.util.concurrent.TimeUnit;

/**
 * @author blossom
 *
 */
public class JoinTest {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {

		JoinTest obj = new JoinTest();
		obj.t1.start();
		obj.t1.join(1000);  // run t1 for 1 second than run t2 and comes back  // Only join() completes the thread
		obj.t2.start();
		
		
		// Below provides the sequencial thread execution:
		
	/*	obj.t1.start();
		obj.t1.join();  // run t1 for 1 second than run t2 and comes back  // Only join() completes the thread
		obj.t2.start();
		obj.t2.join(); 
		obj.t3.start();*/
		
	}

	Thread t1 = new Thread("Thread 1") {
		public void run() {
			System.out.println("Running thead 1");
			try {
				TimeUnit.SECONDS.sleep(2);
				System.out.println("Thread 1 - Returning from sleep");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	};
	Thread t2 = new Thread("Thread 2") {
		public void run() {
			System.out.println("Running thead 2");
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	};
	Thread t3 = new Thread("Thread 3") {
		public void run() {
			System.out.println("Running thead 3");
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	};
}
