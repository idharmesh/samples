package com.mo.prep.interview.arraysandstring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringAnagram {

	public static void main(String[] args) {
		String s1 = "anagram";
		String s2 = "margana";
		
		char[] s = s1.toCharArray();
		
		List<Character> l = new ArrayList<Character>();
		for (int i = 0; i < s2.length(); i++) {
			l.add(s2.charAt(i));
		}
		
		for (int i = 0; i < s1.length(); i++) {
			l.remove((Character)s1.charAt(i));
		}
		

		System.out.println(l.isEmpty());

		String a1 = "hello";
		String a2 = "java";
	
		int i = a1.compareTo(a2);
		System.out.println(i);
		System.out.println(a1.substring(0, 1).toUpperCase() + a1.substring(1));
	}

}
