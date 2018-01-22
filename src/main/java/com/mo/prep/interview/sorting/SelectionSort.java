package com.mo.prep.interview.sorting;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		int[] n = {8,4,2,5,7,9,6,3};
		selectionSort(n);
		System.out.println(Arrays.toString(n));
	}

	private static void selectionSort(int[] n) {
		for (int x = 0; x < n.length; x++) {
			int min = x;
			for (int y = x; y < n.length; y++) {
				if(n[y] < n[min])
					min = y;
			}
			//Since min is now the lowest before moving further, copy it 
			int tmp = n[min];
			n[min] = n[x];
			n[x] = tmp;
		}
	}
	
}
