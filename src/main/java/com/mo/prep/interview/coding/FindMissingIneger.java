package com.mo.prep.interview.coding;

import java.util.BitSet;

public class FindMissingIneger {

	public static void main(String[] args) {
		int[] n = {1,8,2,5,7,9,6,3};
		System.out.println(n.length);

		System.out.println("\n================== 1 ==================");
		// When only one number is missing
		int total = (9*(9+1))/2;
		System.out.println(total);
		int sum =0; 
		for (int i = 0; i < n.length; i++) {
			sum += n[i];
		}
		System.out.println(sum);
		System.out.println("Missing num is : " + (total -sum));
		
		
		System.out.println("\n================== 2 ==================");
		
		///When multiple number is missing:
		missingNumber(n,9);
		
		System.out.println("\n================== 3 ==================");
		
		int[] m = {1,8,2,5,9,6,3};
		missingNumber(m,10);
	}

	private static void missingNumber(int[] m, int count) {
		BitSet bSet = new BitSet(count);
		for (int num : m) {
			bSet.set(num -1);
		}
		int missInd = count - m.length;
		int lastMissingNumber = 0;
		System.out.print("Missing Number: " );
		for (int i = 0; i < missInd; i++) {
			lastMissingNumber = bSet.nextClearBit(lastMissingNumber);
			System.out.print(++lastMissingNumber + ",");
		}
		System.out.println();
	}

}
