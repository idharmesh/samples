/**
 * 
 */
package com.mo.prep.interview.coding;

/**
 * @author blossom
 * Reverse string and print -
 */
public class ReverseStringMS {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(revserseString("hello"));
		System.out.println(printWithDash("hello"));
		rev("hello");
		
		
	}
	
	private static void rev(String s) {
		char[] c = s.toCharArray();
		int k =0, l = s.length() -1;
		for (int i = 0; i < c.length/2; i++) {
			char t = c[i];
			c[i] = c[l-i];
			c[l-i] = t;
		}
		System.out.println(new String(c));
	}
	
	private static String printWithDash(String string) {
		if(string ==null || string.length() < 2)
			return string;
		return string.charAt(0) + "-" + printWithDash(string.substring(1)) ;
	}

	private static String revserseString(String string) {
		if(string ==null || string.length() < 2)
			return string;
		return revserseString(string.substring(1)) + string.charAt(0);
	}

}
