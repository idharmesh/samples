package com.mo.prep.interview.sorting;

import java.util.Arrays;

public class MergeSortPractice1 {

	// Devide - until last element and than merge
	public static void main(String[] args) {

		int arr[] = { 12, 11, 13, 5, 6, 7 };
		System.out.println("Given Array");
		printArray(arr);
		mergerSort(arr, 0, arr.length - 1);
		printArray(arr);

	}

	private static void mergerSort(int[] arr, int l, int r) {
		// find a middle
		if (l < r) {
			int m = (l + r) / 2;
			mergerSort(arr, l, m - 1);
			mergerSort(arr, m + 1, r);
			merge(arr, l, m, r);
		}
	}

	// save both part in 2 tmp array, compare them and copy them to original arr
	private static void merge(int[] arr, int l, int m, int r) {

		int n1 = m - l + 1;
		int n2 = r - m;

		int[] L = new int[n1];
		int[] R = new int[n2];
		for (int i = 0; i < n1; i++) {
			L[i] = arr[l + i];
		}
		for (int i = 0; i < n2; i++) {
			R[i] = arr[m + 1 + i];
		}

		int i = 0, j = 0;
		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] < R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}
		// copy remaining
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}
		
		while(j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}

	/* A utility function to print array of size n */
	static void printArray(int arr[]) {
		System.out.println(Arrays.toString(arr));
	}
}
