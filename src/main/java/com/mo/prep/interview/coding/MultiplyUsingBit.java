package com.mo.prep.interview.coding;

public class MultiplyUsingBit {

	public static void main(String[] args) {

		int result = multBy7(8);
		System.out.println(result);
		
		int low =0, high = 11;
		int mid = low +high;
		System.out.println("mid=" +mid);
		mid = mid >>> 1;
		System.out.println("mid=" +mid);
	}

	private static int multBy7(int i) {
		//Shhift by 8 is mult by 8 - number // 2^3 = 8 so shift by << 3
		int result = i << 3;
		result = result -i;
		return result;
	}

}
