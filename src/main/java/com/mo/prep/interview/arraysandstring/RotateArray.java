package com.mo.prep.interview.arraysandstring;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.util.SystemPropertyUtils;

public class RotateArray {

	public static void main(String[] args) {
		System.out.println(firstRepeatingLetter("abcba"));

		int ar1[] = { 1, 5, 9, 10, 15, 20 };
		int ar2[] = { 2, 3, 8, 13, 45, 11 };

		int a[] = merge(ar1, ar2, ar1.length);
		System.out.println(Arrays.toString(a));
	}
	
	
	void merge(int arr[], int l, int m, int r) {
		// Find sizes of two subarrays to be merged
		int n1 = m - l + 1;
		int n2 = r - m;

		/* Create temp arrays */
		int L[] = new int[n1];
		int R[] = new int[n2];

		/* Copy data to temp arrays */
		for (int i = 0; i < n1; i++)
			L[i] = arr[l + i];
		for (int j = 0; j < n2; j++)
			R[j] = arr[m + 1 + j];

		/* Merge the temp arrays */
		// Initial indexes of first and second subarrays
		int i = 0, j = 0;

		// Initial index of merged subarry array
		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		/* Copy remaining elements of L[] if any */
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		/* Copy remaining elements of L[] if any */
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}
	
	
	
	static String firstRepeatingLetter(String document) {

		char[] charArray = document.toLowerCase().toCharArray();
		Arrays.sort(charArray);
		Map<Character, Integer> uniqueChar = new HashMap<>();
		for (int i = 0; i < charArray.length; i++) {
			if(uniqueChar.containsKey(charArray[i]))
				return charArray[i]+"";
			uniqueChar.put(charArray[i], 1);
		}
		return null;
	}

	public static int[] merge(int[] a, int[] b, int M) {

		int[] answer = new int[M + M];
		int i = 0, j = 0, k = 0;

		while (i < M && j < M)
			if (a[i] < b[j])
				answer[k++] = a[i++];
			else
				answer[k++] = b[j++];

		return answer;
	}

}
