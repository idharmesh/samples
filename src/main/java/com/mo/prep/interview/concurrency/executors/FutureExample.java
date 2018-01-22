package com.mo.prep.interview.concurrency.executors;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class FutureExample {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService exec = Executors.newSingleThreadExecutor();
		Future<Integer> future = exec.submit(new MyCallable());
		System.out.println(future.isDone());
		System.out.println(future.get());
	}
}
class MyCallable implements Callable<Integer> {

	public Integer call() throws Exception {
		TimeUnit.SECONDS.sleep(1);
		return 1;
	}
	
}
