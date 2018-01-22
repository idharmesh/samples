package com.mo.prep.interview.bloomberg;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two lists (A->B->C->D and E->Y->H->C->D), then output the common tail "CD", the time complexity shouldn't be larger than O(n) and space complexity should be O(1)
 * 
 * @author blossom
 *
 */
public class IntersectionOfList {

	public static void main(String[] args) {
		
		List<Character> l1 = new ArrayList<Character>();
		l1.add('A');
		l1.add('B');
		l1.add('C');
		l1.add('D');
		
		List<Character> l2 = new ArrayList<Character>();
		l2.add('E');
		l2.add('Y');
		l2.add('H');
		l2.add('C');
		l2.add('D');
		
		l1.retainAll(l2);
		System.out.println(l1);
		System.out.println(l2);
	}

}
