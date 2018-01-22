package com.mo.prep.interview.concurrency.executors;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

public class NewAPI {

	public static void main(String[] args) {
		
		//Executor only execute runnable..
		// using execute method
		Executor executor = Executors.newCachedThreadPool();
		executor.execute(new Runnable() {
			@Override
			public void run() {
				System.out.println("Runnable from executor!");
			}
		});
		//Executor itself does not have shutdown method..
		
		//use ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
		//to have shutdown method
		ThreadPoolExecutor tpexecutor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
		tpexecutor.shutdownNow();
		
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		//Can submit both Runable and Callable.. Runable returns null as result and callable retursn Future<T>
		//executorService.submit()
		
		//Can invoke list of callable task (seems does not work with runable.
		//executorService.invokeAll()
		executorService.shutdownNow();
		
		//Can exeucute task at specific period of time.
		ScheduledExecutorService scheduleExecutorService = Executors.newScheduledThreadPool(2);
		
		//take both callable and runnable. 
		//scheduleExecutorService.schedule(callable, delay, unit)
		//also has invoke all taking collection fo callable..
		scheduleExecutorService.shutdownNow();
		
	}

}
