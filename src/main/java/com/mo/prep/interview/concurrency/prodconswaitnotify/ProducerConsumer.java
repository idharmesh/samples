package com.mo.prep.interview.concurrency.prodconswaitnotify;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class ProducerConsumer {

	LimitedQueue<Integer> queue = new LimitedQueue<Integer>(4);

	public static void main(String[] args) {
		ProducerConsumer p = new ProducerConsumer();
		System.out.println("Starting Consumer..");
		p.consumer.start();
		System.out.println("Starting Producer..");
		p.producer.start();
		System.out.println("..End of Demo..");
	}

	Thread producer = new Thread("Producer Thread") {
		public void run() {
			for (int i = 0; i < 10; i++) {
				try {
					System.out.println("Producing.. : " + i);
					queue.enqueue(i);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	};

	Thread consumer = new Thread("Consumer Thread") {
		public void run() {

			Integer element = -1;
			while (true) {
				try {
					element = queue.poll();
					System.out.println("Consuming .. : " + element);
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	};
}

class LimitedQueue<T> {
	private int queueSize;
	private Queue<T> queue = new ArrayDeque<T>();
	
	//Technically u can limit arraydeque as underlying element is an array
	

	public LimitedQueue(int queueSize) {
		this.queueSize = queueSize;
		//Technically we can use this..
		//queue = new ArrayDeque<T>(queueSize);
	}

	public synchronized void enqueue(T element) throws InterruptedException {
		
		//while (queue.size() > this.queueSize) {
		while (queue.size() == this.queueSize) {
			wait();
		}
		queue.add(element);
		notify();
	}

	public synchronized T poll() throws InterruptedException {
		T t = null;
		while (queue.isEmpty()) {
			wait();
		}
		t = queue.poll();
		notify();
		return t;
	}
}
