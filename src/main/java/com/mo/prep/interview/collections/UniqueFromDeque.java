package com.mo.prep.interview.collections;

import java.util.ArrayDeque;
import java.util.Deque;

public class UniqueFromDeque {

	
	public static void main(String[] args) {
		Deque<Integer> d = new ArrayDeque<>();
		d.add(5);
		d.add(3);
		d.add(5);
		d.add(2);
		d.add(3);
		d.add(2);
		System.out.println(d.stream().distinct().count());

	}

}

