package com.mo.prep.interview.sorting;

import java.util.Arrays;

import org.springframework.util.SystemPropertyUtils;

public class InsertionSort {

	public static void main(String[] args) {
		int[] n = {8,4,2,5,7,9,6,3};
		int[] m = {34,56,23,45,34,78,66,44};
		//insertionSort(n);
		//quickSort(m, 0, m.length-1);
		//System.out.println(Arrays.toString(n));
		//System.out.println(Arrays.toString(m));
		mergeArray(n,m,n.length);
	}
	
	 static void mergeArray(int[] a, int[] b, int M) {
	       
	        int[] rev = new int[2*M];
	        int f = 0, r = 2*M;
	        while( f<r) {
	        	if(f<M) {
	        		rev[f] = a[f];
	        	}
	        	else {
	        		rev[f] = b[f-M];
	        	}
        		f++;
	        }
	        insertionSort(rev);
	        System.out.println(Arrays.toString(rev));
	    }
	 

	private static void insertionSort(int[] n) {
		for (int i = 1; i < n.length; i++) {
			int val2insert = n[i];
			int j = i;
			while( j > 0 && (n[j-1] > val2insert)) {
				n[j] = n[j-1];
				j--;
			}
			n[j] = val2insert;
		}
	}
	
	private static void reverseSort(int[] n) {
		for (int i = 1; i < n.length; i++) {
			int val2insert = n[i];
			int j = i;
			while( j < 0 && (n[j-1] < val2insert)) {
				n[j] = n[j-1];
				j--;
			}
			n[j] = val2insert;
		}
		
	}

	
	public static void quickSort(int[] arr, int l, int h) {
		if(l < h) {
			
			int p = partition(arr,l,h);
			quickSort(arr, l, p-1);  //exclude pivot as it is already been taken care
			quickSort(arr, p+1, h);
		}
	}

	private static int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int i = low;
		for (int j = low; j < high; j++) {
			if(arr[j] > pivot) {
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				i++;
			}
		}
		//copy pivot as it is less than remaining element
		int tmp = arr[i];
		arr[i] = arr[high];  // this is pivot
		arr[high] = tmp;
		return i;
	}

   
}
