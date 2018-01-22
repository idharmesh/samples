package com.mo.prep.interview.coding;

import java.util.ArrayList;
import java.util.List;

public class PassByValueTest {

	public static void main(String[] args) {
		
		Integer x = 10;
		Integer y = 12;
		
		swap(x,y);
		System.out.println("\n=== MAIN == \n");
		System.out.println("X= " +x);
		System.out.println("Y= " +y);
		
		x = 10;
		y = 12;
		//Using + -
		swap2(x,y);
		System.out.println("\n=== Swap 2== \n");
		System.out.println("X= " +x);
		System.out.println("Y= " +y);
		
		//swap(30,32);
		List<String> l = new ArrayList<String>();
		l.add("First String");
		fill(l);
		System.out.println(l);
	}

	private static void fill(List<String> l) {
		l.add("Second String");
	}

	private static void swap(Integer x, Integer y) {
		System.out.println("X=" +x + " Y=" +y);
		x = x^y;
		System.out.println(x);
		y=x^y;
		System.out.println(y);
		x=x^y;
		System.out.println(x);
		System.out.println("\n=== Swap == \n");
		System.out.println("X= " +x);
		System.out.println("Y= " +y);
		
		
		
	}
	
	
	private static void swap2(Integer x, Integer y) {
		System.out.println("X=" +x + " Y=" +y);
		x = x+y;
		System.out.println(x);
		y=x-y;
		System.out.println(y);
		x=x-y;
		System.out.println(x);
		System.out.println("\n=== Swap == \n");
		System.out.println("X= " +x);
		System.out.println("Y= " +y);
		
		
		
	}
	
	

}
