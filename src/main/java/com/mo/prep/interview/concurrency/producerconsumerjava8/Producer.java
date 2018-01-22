package com.mo.prep.interview.concurrency.producerconsumerjava8;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class Producer implements Callable<Integer>{
	
	BlockingQueue<Integer> queue;

	public Producer(BlockingQueue<Integer> queue2) {
		this.queue = queue2;
	}

	public Integer call() throws Exception {
		for(int i=0; i<10; i++) {
			TimeUnit.SECONDS.sleep(2);
			System.out.println("Prducing : " + i);
			queue.put(i);
			
		}
		return null;
	}


//	public E call() throws Exception {
//		System.out.println("Consuming : "+ queue.take());
//		return null;
//	}
}
