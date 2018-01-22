package com.mo.prep.interview.concurrency;

public class HelloRunable implements Runnable {

	@Override
	public void run() {
		System.out.println("Hello from runnables run..");
	}

	public static void main(String[] args) {
		new Thread(new HelloRunable()).start();
	}

}
