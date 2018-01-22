/**
 * 
 */
package com.mo.prep.interview.coding;

import java.util.Arrays;

/**
 * @author blossom
 *
 */
public class ReverseArrayInPlace {

	
	public static void reverseArray(String[] arr) {
		if((arr == null) || arr.length < 2)
			return;
		for (int i = 0; i < arr.length / 2; i++) {
			String tmp = arr[0];
			arr[i] = arr[arr.length -1 -i];
			arr[arr.length - 1 -i] = tmp;
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String arr[] = {"a","b","c","d","e"};
		System.out.println(Arrays.toString(arr));
		reverseArray(arr);
		System.out.println(Arrays.toString(arr));
	}

}
