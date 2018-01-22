package com.mo.prep.interview.bloomberg;

import java.util.ArrayList;
import java.util.List;
/**
 * Java 5 introduces Wrapper class around primitive data types, however there was also a generic strong
 * typification introduces, however for the wrapper data types, it implemented to translate primitives to 
 * wrapper and vice-versa internally, and hence below code does not throw class cast exception  
 * 
 * @author blossom
 *
 */
public class AutoBoxing {
	static long l = 100L;
	static int i =10;
	public static void main(String[] args) {

		List<Long> listOfLong = new ArrayList<Long>();
		listOfLong.add(l);
		
		long someLong = listOfLong.get(0);
		System.out.println("Some Long value= " + someLong);
		
		List<Integer> listOfInteger = new ArrayList<Integer>();
		listOfInteger.add(i);
		
		long someInteger = listOfInteger.get(0);
		System.out.println("Some Integer value= " + someInteger);
		
	}

}
