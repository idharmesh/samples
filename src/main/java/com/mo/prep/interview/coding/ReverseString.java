package com.mo.prep.interview.coding;

import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class ReverseString {
	
	int count = 0;

	synchronized void  increment() {
	    count = count + 1;
	}
	
	public void exec() {
		ExecutorService executor = Executors.newFixedThreadPool(2);

		IntStream.range(0, 10000)
		    .forEach(i -> executor.submit(this::increment));

		stop(executor);

		System.out.println(count);
	}
	public static void main(String[] args) {
		String rev = revStr("hello");
		System.out.println("Rev: (hell0) " + rev);
		
		ReverseString s = new ReverseString();
		s.exec();
		
		System.out.println(reverseString("Some String"));
		
	}
	
	public static String reverseString(String s){
		if(s == null || s.length() < 2)
			return s;
		char[] chars = s.toCharArray();
		int lengh = s.length();
		int last =lengh -1;
		
		for (int i = 0; i < lengh/2; i++) {
			char c = chars[i];
			chars[i] = chars[last-i];
			chars[last-i] = c;
		}
		return new String(chars);
	}

	private static String revStr(String str) {
		
		if(str.length() < 2)
			return str;
		return revStr(str.substring(1)) + str.charAt(0);
	}
	
	public static void stop(ExecutorService executor) {
        try {
            executor.shutdown();
            executor.awaitTermination(60, TimeUnit.SECONDS);
        }
        catch (InterruptedException e) {
            System.err.println("termination interrupted");
        }
        finally {
            if (!executor.isTerminated()) {
                System.err.println("killing non-finished tasks");
            }
            executor.shutdownNow();
        }
    }
	
}
