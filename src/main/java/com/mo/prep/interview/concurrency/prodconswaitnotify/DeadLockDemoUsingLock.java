package com.mo.prep.interview.concurrency.prodconswaitnotify;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock; 

/* 
 *  Either run jvisualvm, select running processe, goto Thread tab and you will if there is any dead lock,now can see details from ThreadDump
*   
*   Or   run below command
*   
*   jstack -l pid
*   
*   hmap jhisto :live pid   - this will list all the class for given process. Can find if there are multiple object for singleton   
*/
public class DeadLockDemoUsingLock {

	Lock lock1 = new ReentrantLock();
	Lock lock2 = new ReentrantLock();

	Thread thread1 = new Thread("Thread #1") {
		public void run() {
			System.out.println("Starting : " + this.getName());
			while (true) {
				try {
					lock1.lock();
					System.out.println("Acquired lock1 and executing further...in " + this.getName());
					try {
						TimeUnit.SECONDS.sleep(2);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					try {
						lock2.lock();
						System.out.println("Acquired lock2 and breaking loop...in " + this.getName());
						break;
					} finally {
						lock2.unlock();
					}
				} finally {
					lock1.unlock();
				}

			}
		}
	};

	Thread thread2 = new Thread("Thread #2") {
		public void run() {
			System.out.println("Starting : " + this.getName());
			while (true) {
				try {
					lock2.lock();
					System.out.println("Acquiring lock2 and executing further ... in " + this.getName());
					try {
						TimeUnit.SECONDS.sleep(2);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					try {
						lock1.lock();
						System.out.println("Acquiring lock1 and breaking loop ... in " + this.getName());
						break;
					}
					finally {
						lock1.unlock();
					}
				} 
				finally {
					lock2.unlock();
				}
			}
		}
	};

	public static void main(String[] args) {
		DeadLockDemoUsingLock demo = new DeadLockDemoUsingLock();
		demo.thread1.start();
		demo.thread2.start();

	}

}
