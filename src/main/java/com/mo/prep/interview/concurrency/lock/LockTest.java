package com.mo.prep.interview.concurrency.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
	
	Lock lock = new ReentrantLock();

	public void someMethod() throws InterruptedException {
		lock.tryLock(1, TimeUnit.SECONDS);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
