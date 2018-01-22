package com.mo.prep.interview.arraysandstring;

import java.util.Arrays;

/*
 * Give an array [1,2,3,4,5,6,7,8,9], output result should be production without current member, 
 * 	like [2*3*4*5*6*7*8*9, 1*3*4*5*6*7*8*9, ...., 1*2*3*4*5*6*7*8]. 
  No division allowed and must consider the large production number bigger than integer limitation. 
  Also need to consider how to handle big size of input, like one million elements inside the input array
 */
public class ProductOfArray {
	
	static int min= 51, max = 55;
	
	//consider one million input.
	//So one shall ask if there is any predefined min and max defined
	
	public static void main(String[] args) {
		long[] array = initArray();
		long[] result = arrayProduct(array);
		System.out.println("Orignal : " + Arrays.toString(array));
		System.out.println("Result : " + Arrays.toString(result));
	}


	private static long[] initArray() {
		//return new long[]{1,2,3,4,5}; 
		//or
		//construct something using min and max.
		int range = max - min + 1;
		long[] arr = new long[range];
		for (int i = 0; i < range; i++) {
			arr[i] = (min++);
		}
		return arr;
	}


	private static long[] arrayProduct(long[] arr) {
		long[] result = Arrays.copyOf(arr, arr.length);
		for (int i = 0; i < arr.length; i++) {
			long r = 1;
			for (int j = 0; j < arr.length; j++) {
				if(i != j ) {
					r = r * arr[j]; 
				}
			}
			result[i] = r;
		}
		return result;
	}
	
	
}
