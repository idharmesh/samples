package com.mo.prep.interview.achase;

import java.util.Scanner;

/**
 * Binary search index of
 * 
 * @author blossom
 *
 */
public class BinarySearchExample {
	public static void main(String[] args) {
		int key = 77;
		int[] num ={14,25,56,58,65,69,77,78,90,92};// new int[10];
		// Fill the array
		Scanner scanner = new Scanner(System.in);
		//for (int i = 0; i < 10; i++)
			//num[i] = scanner.nextInt();
		// The binary search method
		int position = indexOf(num, key);
		System.out.println("The number was found  position : " + position);
		int number= rBsearch(num, 0, 9, key);
		System.out.println("The number found  is : " + number);
		//binarySearch(num, 0, 9, key);
		
	}
	  public static int indexOf(int[] a, int key) {
	        int lo = 0;
	        int hi = a.length - 1;
	        while (lo <= hi) {
	            // Key is in a[lo..hi] or not present.
	            int mid = lo + (hi - lo) / 2;
	            if      (key < a[mid]) hi = mid - 1;
	            else if (key > a[mid]) lo = mid + 1;
	            else return mid;
	        }
	        return -1;
	    }
	
	public static int rBsearch(int[] L, int low, int high, int k) {

	    int mid = (low + high) / 2;

	    if (low > high) {
	        return -1;
	    } else if (L[mid] == k) {
	        return L[mid];
	    } else if (L[mid] < k) {
	        return rBsearch(L, mid + 1, high, k);
	    } else {
	    	return rBsearch(L, low, mid - 1, k);
	    }
	 }
	// Binary Search Method
	// This method accepts a pre-sorted array, the subscript of the starting
	// element for the search,
	// the subscript of the ending element for the search,
	// and the key number for which we are searching.
	public static void binarySearch(int[] array, int lowerbound, int upperbound, int key) {
		int position;
		int comparisonCount = 1; // counting the number of comparisons
									// (optional)

		// To start, find the subscript of the middle position.
		position = (lowerbound + upperbound) / 2;

		while ((array[position] != key) && (lowerbound <= upperbound)) {
			comparisonCount++;
			if (array[position] > key) // If the number is > key, ..
			{ // decrease position by one.
				upperbound = position - 1;
			} else {
				lowerbound = position + 1; // Else, increase position by one.
			}
			position = (lowerbound + upperbound) / 2;
		}
		if (lowerbound <= upperbound) {
			System.out.println("The number was found in array subscript" + position);
			System.out.println("The binary search found the number after " + comparisonCount + "comparisons.");
			// printing the number of comparisons is optional
		} else
			System.out.println("Sorry, the number is not in this array.  The binary search made " + comparisonCount
					+ " comparisons.");
	}
}
