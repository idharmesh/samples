package com.mo.prep.interview.concurrency.producerconsumerjava8;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQUsingLockAndCondition<T> {
	Queue<T> queue = new LinkedList<>();
	int capacity;
	Lock lock = new ReentrantLock();
	Condition full = lock.newCondition();
	Condition empty = lock.newCondition();
	
	public BlockingQUsingLockAndCondition(int initCapacity) {
		this.capacity = initCapacity;
	}
	
	public void put(T element) throws InterruptedException {
		lock.lock();
		try {
			while(queue.size() == capacity) {
				full.await();
			}
			queue.add(element);
			empty.signal();
		}
		finally {
			lock.unlock();
		}
	}
	
	public T take() throws InterruptedException {
		lock.lock();
		try {
			T e;
			while(queue.isEmpty()) {
				empty.await();
			}
			e = queue.remove();
			full.signalAll();
			return e;
		}
		finally{
			lock.unlock();
		}
	}
}
