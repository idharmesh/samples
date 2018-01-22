package com.mo.prep.interview.concurrency.executors;

import java.time.LocalTime;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.springframework.util.StopWatch;

public class ShudownServiceCheck {
	
	static Callable<Integer> task = () -> {
		System.out.println(" - Executing Callable task - ");
		TimeUnit.SECONDS.sleep(5);
		System.out.println(" - Executing Callable task - Printing after 5 seconds of Sleep..");
		return 100;
	};
	
	public static void main(String[] args) {
		
		StopWatch lap = new StopWatch();
		lap.start();
		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.submit(task);
		
		try {
			System.out.println("In try - shutdown ");
			executor.shutdown();
			executor.awaitTermination(3, TimeUnit.SECONDS);
			//executor.awaitTermination(5, TimeUnit.SECONDS);
			System.out.println("In try - after await ");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		finally {
			lap.stop();
			System.out.println("In Finally - shutdownnow " + lap.getTotalTimeSeconds());
			if(!executor.isTerminated()) {
				System.out.println("Executor Service is still running!");
			}
			executor.shutdownNow();
			System.out.println("Shutdown Finished");
		}
		
		System.out.println(LocalTime.now());
	}

}
