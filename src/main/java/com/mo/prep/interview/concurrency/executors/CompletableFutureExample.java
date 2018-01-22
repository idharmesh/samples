package com.mo.prep.interview.concurrency.executors;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.function.Supplier;

public class CompletableFutureExample {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService exec = Executors.newSingleThreadExecutor();
		CompletableFuture<Integer> cf = CompletableFuture.supplyAsync(new MySupplier(),exec);
		System.out.println("Is cf Done?"  + cf.isDone());
		CompletableFuture<Integer> cf2 = cf.thenApply(new PlusOne());
		System.out.println(cf2.get());
	}
}

class MySupplier implements Supplier<Integer>{

	public Integer get() {
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return 1;
	}
}

class PlusOne implements Function<Integer, Integer> {

	public Integer apply(Integer x) {
		return x + 1;
	}
}