package com.mo.prep.interview.sorting;

public class CheckOddNumber {

	public static void main(String[] args) {
		System.out.println(0x1);
		System.out.println((10 & 0x1));
		boolean isOdd = checkOdd(21);
		System.out.println(isOdd);
		isOdd = checkOdd(22);
		System.out.println(isOdd);
		
		boolean isEven = checkeven(50);
		System.out.println(isEven);
		isEven = checkeven(51);
		System.out.println(isEven);
		System.out.println(8 << 4);
	}

	private static boolean checkOdd(int i) {
		return ((i & 0x1) == 1);
	}

	private static boolean checkeven(int i) {
		return ((i & 0x1) == 0);
	}
	
	private static int isPowerOfTwo(int x) {
		//return ((x!=0) && !(x&(x-1)));
		return 0;
	}
	
}

		  		  		  

