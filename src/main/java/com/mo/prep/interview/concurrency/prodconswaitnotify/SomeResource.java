package com.mo.prep.interview.concurrency.prodconswaitnotify;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class SomeResource {

	Lock lock1 = new ReentrantLock();
	Lock lock2 = new ReentrantLock();
	Queue<Integer> q = new ArrayDeque<>();
	
	public void enque(int v) throws InterruptedException {
		synchronized (lock1) {
			System.out.println("Enque #1: Locked - Lock 1 in enque");
			TimeUnit.SECONDS.sleep(2);
			synchronized (lock2) {
				System.out.println("Enque #2: Locked - Lock 2 in enque");
				TimeUnit.SECONDS.sleep(2);
				q.add(v);
			}
		}
	}
	
	public int poll() throws InterruptedException {
		synchronized (lock2) {
			System.out.println("poll #1 Locked - Lock 2 in poll ");
			TimeUnit.SECONDS.sleep(2);
			synchronized (lock1) {
				System.out.println("poll #2 Locked - Lock 1 in poll ");
				TimeUnit.SECONDS.sleep(2);
			}
			
		}
		
		return (!q.isEmpty()?q.poll():0);
	}
	
	

	public static void main(String[] args) {
		SomeResource resource = new SomeResource();
		Thread t1 = new Thread("Thread 1") {
			public void run() {
				System.out.println(this.getName() + " Started");
				try {
					resource.enque(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		Thread t2 = new Thread("Thread 2") {
			public void run() {
				System.out.println(this.getName() + " Started");
				try {
					resource.poll();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		
		t1.start();
		t2.start();
	}

}
