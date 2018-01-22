package com.mo.prep.interview.coding;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class LinkedHashSetTest {

	public static void main(String[] args) {

		HashSet<Integer> hSet = new HashSet<>();
		for (int i = 0; i < 25; i++) {
			hSet.add(i);
		}
		for (Integer integer : hSet) {
			//System.out.println(integer);
		}
		
		LinkedHashSet<Integer> lhSet = new LinkedHashSet<>();
		for (int i = 0; i < 25; i++) {
			lhSet.add(i);
		}
		
		for (Integer integer : lhSet) {
			System.out.println(integer);
		}
	}

}
