package com.mo.prep.interview.amzon;

public class FindFirstOccurence {

	public static void main(String[] args) {
		String s =  "abdccdefga";
		char[] c = s.toCharArray(); 
		for (int i = 0; i < c.length; i++) {
			if(i!=s.lastIndexOf(c[i])) {
				System.out.println(c[i]);
				break;
			}
		}
	}
}
