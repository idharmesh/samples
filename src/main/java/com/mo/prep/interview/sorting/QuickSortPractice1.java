package com.mo.prep.interview.sorting;

import java.util.Arrays;

public class QuickSortPractice1 {

	public static void main(String[] args) {
		int[] arr = {5,8,2,3,7,9,1,4};
		System.out.println(Arrays.toString(arr));
		quickSort(arr,0,arr.length -1);
		System.out.println(Arrays.toString(arr));
		
	}

	private static void quickSort(int[] arr, int low, int high) {
		if(low  < high) {
			//get the partition index
			int p = partition(arr,low,high);
			//since we already took care of pivot
			quickSort(arr, low, p -1);
			quickSort(arr, p +1, high);
		}
	}

	private static int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int i = low;
		for (int j = low; j < high; j++) {
			if(arr[j] < pivot) {
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				i++;
			}
		}
		//copy pivot as it is smaller than the element after i
		int tmp = arr[i];
		arr[i] = arr[high];
		arr[high] = tmp;
		return i;
	}
}
