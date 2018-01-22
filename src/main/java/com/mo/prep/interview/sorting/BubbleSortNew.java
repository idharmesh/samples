package com.mo.prep.interview.sorting;

import java.util.Arrays;

public class BubbleSortNew {

	public static void main(String[] args) {
		int[] n = {8,4,2,5,7,9,6,3};
		bubble(n);
		System.out.println(Arrays.toString(n));
	}

	private static void bubble(int[] n) {
		for (int i = 0; i < n.length-2; i++) {
			for (int j = 0; j < n.length -1 - i; j++) {
				if(n[j+1] < n[j]) {
					int tmp = n[j+1];
					n[j+1] = n[j];
					n[j] = tmp;
				}
			}
		}
	}

}
