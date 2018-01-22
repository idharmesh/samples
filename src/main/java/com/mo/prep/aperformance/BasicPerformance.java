package com.mo.prep.aperformance;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.util.StopWatch;

public class BasicPerformance {
	Object lock = new Object();
	public static void main(String[] args) {
		int SIZE = 32;
		Object[] data = new Object[SIZE];
		for (int i = 0; i < SIZE; i++) {
			System.out.println((int)(i%SIZE));
		}
		

		BasicPerformance test = new BasicPerformance();
		test.checkPerformanceSingleThread();
		test.checkPerformanceSynchronized();
		test.checkPerformanceAtomicChange();
	}
	
	public void checkPerformanceSingleThread() {
		StopWatch lap = new StopWatch();
		lap.start();
		long value = 0;
		while(value < 10000000L)
			value++;
		lap.stop();
		System.out.println("Single thread - Time taken :" + lap.getTotalTimeMillis());
	}

	public void checkPerformanceSynchronized() {
		StopWatch lap = new StopWatch();
		
		lap.start();
		long value = 0;
		while(value < 10000000L) {
			synchronized (lock) {
				value++;
			}
		}
			
		lap.stop();
		System.out.println("Synchronized - Time taken :" + lap.getTotalTimeMillis());
	}
	
	public void checkPerformanceAtomicChange() {
		StopWatch lap = new StopWatch();
		lap.start();
		AtomicLong value = new AtomicLong(0);
		long result = 0;
		while(result < 10000000L) {
			result = value.incrementAndGet();
		}
			
		lap.stop();
		System.out.println("Atomic long - Time taken :" + lap.getTotalTimeMillis());
	}
}
