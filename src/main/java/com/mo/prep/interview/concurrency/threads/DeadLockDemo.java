package com.mo.prep.interview.concurrency.threads;

import java.util.concurrent.TimeUnit;
/**
 * How to know the deadlock?
 * 
 * 	Either run jvisualvm, select running processe, goto Thread tab and you will if there is any dead lock,now can see details from ThreadDump
 * 
 *   Or   run below command
 *   jstack -l pid
 *   
 *   hmap jhisto :live pid   - this will list all the class for given process. Can find if there are multiple object for singleton   
 *   
 *   
 * @author blossom
 *
 */
public class DeadLockDemo {

	private String str1 = "String1";
	private String str2 = "String2";

	public static void main(String[] args) {
		DeadLockDemo demo = new DeadLockDemo();
		demo.t1.start();
		demo.t2.start();
	}

	Thread t1 = new Thread("Blossom") {
		public void run() {
			while (true) {
				synchronized (str1) {
					System.out.println("Thread 1 - Sync on Str 1");
					try {
						TimeUnit.SECONDS.sleep(2);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized (str2) {
						System.out.println("Thread 1 - Sync on Str 2");
					}

				}
			}
		}
	};

	Thread t2 = new Thread("Arushi") {
		public void run() {
			while (true) {
				synchronized (str2) {
					System.out.println("Thread 2 - Sync on Str 2");
					try {
						TimeUnit.SECONDS.sleep(2);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized (str1) {
						System.out.println("Thread 2 - Sync on Str 1");
					}
				}
			}
		}
	};
}
