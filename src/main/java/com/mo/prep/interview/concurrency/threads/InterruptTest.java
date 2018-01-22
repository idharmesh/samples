package com.mo.prep.interview.concurrency.threads;

import java.util.concurrent.TimeUnit;

public class InterruptTest {

	public static void main(String[] args) throws InterruptedException {
		
		InterruptTest interruptTest = new InterruptTest();
		interruptTest.t.start();
		TimeUnit.SECONDS.sleep(2);
		interruptTest.t.interrupt();

	}
	
	Thread t = new Thread("Interrupt Thread") {
		public void run() {
			System.out.println("Thread started.");
			while(true){
				if(interrupted()) {
					System.out.println("Thread is interrupted...");
					break;
				}
			}
		}
	};
}
