package com.mo.prep.interview.concurrency.prodconswaitnotify;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class ProdConsumerMain {
	
	LimitedSizeQueue<Long> queue = new LimitedSizeQueue<>(5);
	
	public static void main(String[] args) {
		
		ProdConsumerMain classObject = new ProdConsumerMain();
		classObject.producer.start();
		classObject.consumer.start();
	}
	
	Thread producer = new Thread("Producer Thread") {

		public void run() {
			System.out.println("Starting : " + this.getName());
			for (Long i = 1000000000000000000L; i < 1000000000000000100L; i++) {
				try {
					TimeUnit.SECONDS.sleep(0);
					System.out.println("Producing : " + i);
					queue.enqueue(i);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	};
	
	Thread consumer = new Thread("Consumer Thread") {
		public void run() {
			System.out.println("Starting : " + this.getName());
			while(true) {
				try {
					System.out.println("Consuming : " + queue.poll());
					TimeUnit.SECONDS.sleep(0);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		}
	};

}

class LimitedSizeQueue<T> {
	
	private Queue<T> queue = null;
	private int capacity = 0;
	public LimitedSizeQueue(int capacity) {
		super();
		this.capacity = capacity;
		this.queue = new ArrayDeque<T>(capacity);
	}
	
	public synchronized void enqueue(T data) throws InterruptedException {
		
		while(queue.size() == capacity) {
			wait();
		}
		queue.add(data);
		notifyAll();
	}
	
	public synchronized T poll() throws InterruptedException {
		T data;
		while(queue.isEmpty()) {
			wait();
		}
		data = queue.poll();
		notifyAll();
		return data;
	}
}