/**
 * 
 */
package com.mo.prep.interview.concurrency.producerconsumerjava8;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author blossom
 * http://javarevisited.blogspot.sg/2012/02/producer-consumer-design-pattern-with.html
 *
 */
public class ProducerConsumerDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		BlockingQueue<Integer> queue = new LinkedBlockingQueue<Integer>();
		
		//For limited size of the queue
		queue = new ArrayBlockingQueue<>(5);
		
		Callable<Integer> producer = new Producer(queue);
		Callable<Integer> consumer = new Consumer(queue);
		
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		executorService.submit(producer);
		executorService.submit(consumer);
		
		executorService.shutdown();
	}

}
