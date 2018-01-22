package com.mo.prep.interview.coding;

import java.util.ArrayList;
import java.util.List;

public class GenericsTest {

	public static void main(String[] args) {

		List<Number> l = new ArrayList<>();
		l.add(10);
		l.add(10.10);
		System.out.println(l);
		
		List<String> s = new ArrayList<>();
		s.add("test");
		List<Object> o = new ArrayList<>();
		o.add(new Object());
		o.addAll(s);
		System.out.println(o);
		
		//List<Object> oo = s; 
	}

}
