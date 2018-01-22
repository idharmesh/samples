package com.mo.prep.interview.arraysandstring;

import java.util.Arrays;

/**
 * 	Given two strings, write a method to decide if one is a permutation of the other.
	
 * @author blossom
 *
 */
public class StringPermutationOld {

	static void checkIfStringPermutation() {
		
		String s1 = "abc";
		String s2 = "cab";
		char[] sc1 = s1.toCharArray();
		char[] sc2 = s2.toCharArray();
		Arrays.sort(sc1);
		Arrays.sort(sc2);
		
		//Other one may be creating array list and removing char and see if size is 0
		
		boolean isPerm = true;
		for (int i = 0; i < sc1.length; i++) {
			for (int j = i; j < sc2.length; j++) {
				if(i==j && sc1[i] != sc2[j]) {
					isPerm = false;
					break;
				}
			}
		}
		
		System.out.println("Is perm : " + isPerm);
		
		//Or
		System.out.println(new String(sc1).equalsIgnoreCase(new String(sc2)));
		
		//Or
		if((Arrays.toString(sc2)).equalsIgnoreCase(Arrays.toString(sc1))){
			System.out.println(s1 + " & " + s2 + " are permutation");
		}
		else {
			System.out.println(s1 + " & " + s2 + " are not a permutation");
		}
	}
	
	public static void main(String[] args) {
		checkIfStringPermutation();
	}

}
