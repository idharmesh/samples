package com.mo.prep.interview.concurrency.producerconsumerjava8;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class Consumer implements Callable<Integer> {
	BlockingQueue<Integer> queue;
	
	public Consumer(BlockingQueue<Integer> queue2) {
		this.queue = queue2;
	}
	public Integer call() throws Exception {
		while(true)  {
			TimeUnit.SECONDS.sleep(1);
			System.out.println("Consuming : "+ queue.take());
		}
	}
}
