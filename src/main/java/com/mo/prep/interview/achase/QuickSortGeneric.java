package com.mo.prep.interview.achase;

import java.util.Arrays;

public class QuickSortGeneric<T extends Comparable<T>> {
	
	public static void main(String[] args) {
		
		QuickSortGeneric<Integer> sorter = new QuickSortGeneric<Integer>();
		Integer[] data = {4,3,2,0,1};
		sorter.sort(data);
		System.out.println(Arrays.toString(data));
		
		Character[] cdata = {'E','A','D','C','B'};
		QuickSortGeneric<Character> cSorter = new QuickSortGeneric<Character>();
		cSorter.sort(cdata);
		System.out.println(Arrays.toString(cdata));
		
	}
	
	/**
	 * @param array
	 */
	public void sort(T[] array) {
		array = quicksort(array, 0, array.length - 1);
	}

	/**
	 * quicksort - initiate quicksort
	 * @param array
	 * @param lo
	 * @param hi
	 * @return the t[]
	 */
	private T[] quicksort(T[] array, int lo, int hi) {
		if (hi > lo) {
			int partitionPivotIndex = (int) (Math.random() * (hi - lo) + lo);
			int newPivotIndex = partition(array, lo, hi, partitionPivotIndex);
			quicksort(array, lo, newPivotIndex - 1);
			quicksort(array, newPivotIndex + 1, hi);
		}
		return (T[]) array;
	}

	/**
	 * Partition Function
	 * @param array
	 * @param lo
	 * @param hi
	 * @param pivotIndex
	 * @return the int
	 */
	private int partition(T[] array, int lo, int hi, int pivotIndex) {
		T pivotValue = array[pivotIndex];
		swap(array, pivotIndex, hi); // send to the back
		int index = lo;
		for (int i = lo; i < hi; i++) {
			if (( array[i]).compareTo(pivotValue) <= 0) {
				swap(array, i, index);
				index++;
			}
		}
		swap(array, hi, index);
		return index;
	}

	/**
	 * Swap.
	 * @param array
	 * @param i
	 * @param j
	 */
	private void swap(T[] array, int i, int j) {
		T temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}