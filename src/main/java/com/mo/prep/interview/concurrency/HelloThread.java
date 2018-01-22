package com.mo.prep.interview.concurrency;

public class HelloThread extends Thread {
	public void run() {
		System.out.println("Hello from threads run...");
	}
	public static void main(String[] args) {
		new HelloThread().start();
		new Thread(r).start();
	}
	
	static Runnable r = new Runnable() {
		
		@Override
		public void run() {
			System.out.println("Anonymous runnable");
		}
	};

}
