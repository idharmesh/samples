package com.mo.prep.interview.achase;

import java.util.Arrays;
import java.util.List;

public class IntegerToBinary {

	public static void main(String[] args) {
		
		int i = 8;
		String binary = int2bin(i);
		System.out.println(binary);
		
		System.out.println(Integer.toBinaryString(i));
		
		char[] a1 = binary.toCharArray();
		char[] a2 = Integer.toBinaryString(i).toCharArray();
		
		System.out.println(Arrays.equals(a1, a2));
		a2 = Integer.toBinaryString(9).toCharArray();
		System.out.println(compareBinaryArray(a1,a2));
		
		
	}

	
	// Or can be done as Arrays.equals(a1, a2)
	private static boolean compareBinaryArray(char[] a1, char[] a2) {
		int len1 = a1.length;
		int len2 = a2.length;
		if(len1 != len2) {
			return false;
		}
		
		for (int i = 0; i < len1; i++) {
			if(a1[i] != a2[i]) { 
				return false;
			}
		}
		
		return true;
	}
	



	private static String int2bin(int i) {
		StringBuilder sb = new StringBuilder();
		while(i > 0) {
			sb.append(i%2);
			i = i/2;
		}
		return sb.reverse().toString();
	}
	
	

}
