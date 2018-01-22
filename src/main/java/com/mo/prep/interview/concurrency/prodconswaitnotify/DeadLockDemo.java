package com.mo.prep.interview.concurrency.prodconswaitnotify;

import java.util.concurrent.TimeUnit;

public class DeadLockDemo {

	Object lock1 = new Object();
	Object lock2 = new Object();
	
	Thread thread1 = new Thread("Thread #1"){
		public void run() {
			System.out.println("Starting : " + this.getName());
			while(true) {
				synchronized (lock1) {
					System.out.println("Acquired lock1 and executing further...in " + this.getName());
					try {
						TimeUnit.SECONDS.sleep(2);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized (lock2) {
						System.out.println("Acquired lock2 and breaking loop...in " + this.getName());
						break;
					}
					
				}
			}
		}
	};
	
	Thread thread2 = new Thread("Thread #2"){
		public void run() {
			System.out.println("Starting : " + this.getName());
			while(true) {
				synchronized (lock2) {
					System.out.println("Acquiring lock2 and executing further ... in " + this.getName());
					try {
						TimeUnit.SECONDS.sleep(2);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized (lock1) {
						System.out.println("Acquiring lock1 and breaking loop ... in " + this.getName());
						break;
					}
				}
			}
		}
	};
	
	
	public static void main(String[] args) {
		DeadLockDemo demo = new DeadLockDemo();
		demo.thread1.start();
		demo.thread2.start();

	}

}
