package com.mo.prep.interview.sorting;

import java.util.Arrays;

public class BucketSort {

	public static void main(String[] args) {

	
		int[] array = { 2, 1, 5, 1, 2, 3, 4, 3, 5, 6, 7, 8, 5, 6, 7, 0 };
		int[] sort = new BucketSort().sort(array, 0, 8);
		System.out.println(Arrays.toString(sort));
		for (int i = 0; i < sort.length; i++) {
			for (int j = 0; j < sort[i]; j++) {
				System.out.print(i+",");
			}
		}
	}

	public int[] sort(int[] array, int min, int max) {
		int range = max - min + 1;
		int[] result = new int[range];
		for (int i : array) {
			result[i]++;
		}
		return result;
	}


	

}
