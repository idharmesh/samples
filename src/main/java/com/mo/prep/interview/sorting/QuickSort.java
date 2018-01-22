package com.mo.prep.interview.sorting;

import java.util.Arrays;

/**
 * Quick sort is a 2 step process.
 * 1. Partition and sort
 * During partition, select an element and tham move element as require
 * 
 * o( n log n) -- average
 * o(n2) - worst case 
 * 
 * @author blossom
 *
 */


public class QuickSort {

	public static void main(String[] args) {
		
		int[] arr = new int[]{5,8,2,3,7,9,1,4};
		System.out.println("l="+0);
		System.out.println("h="+ (arr.length - 1));
		System.out.println(Arrays.toString(arr));
		QuickSort sort = new QuickSort();
		sort.quickSort(arr,0,arr.length -1);
		System.out.println(Arrays.toString(arr));
	}
	
	
	public void quickSort(int[] arr, int l, int h) {
		if(l < h) {
			
			int p = partition(arr,l,h);
			System.out.println("l="+l);
			System.out.println("h="+h);
			System.out.println("p="+p);
			quickSort(arr, l, p-1);  //exclude pivot as it is already been taken care
			quickSort(arr, p+1, h);
		}
	}

	private int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int i = low;
		for (int j = low; j < high; j++) {
			if(arr[j] < pivot) {
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				i++;
				System.out.println(Arrays.toString(arr));
			}
		}
		//copy pivot as it is less than remaining element
		int tmp = arr[i];
		arr[i] = arr[high];  // this is pivot
		arr[high] = tmp;
		return i;
	}

}
