package com.mo.prep.interview.concurrency.executors;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class CallableWithResultExample {
	
	
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		Runnable task = new Runnable() {
			@Override
			public void run() {
				System.out.println("Running runnable's run..");
				try {
					TimeUnit.SECONDS.sleep(3);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		};
		ExecutorService executor = Executors.newSingleThreadExecutor();
		Future<?> result = executor.submit(task);
		System.out.println(result.isDone());
		System.out.println(result.isCancelled());
		result.get();
		System.out.println(result.isDone());
		
	}
}
