package com.mo.prep.interview.amzon;

import java.util.Arrays;

public class MergeArraysSorted {

	public static void main(String[] args) {
		
		int ar1[] = { 1, 5, 9, 10, 15, 20 };
		int ar2[] = { 2, 3, 8, 13, 45, 11 };
		merge(ar1, ar2, ar1.length-1);
	}

	private static void merge(int[] ar1, int[] ar2, int M) {
		int[] tmp = new int[2*M];
		int i=0, j=0, k=0;
		while(k < (2*M)) {
			if(ar1[i] < ar2[j]) {
				tmp[k] = ar1[i];
				i++;
			}
			else{
				tmp[k] = ar2[j];
				j++;
			}
			k++;
		}
		System.out.println(Arrays.toString(tmp));
	}
	
}
