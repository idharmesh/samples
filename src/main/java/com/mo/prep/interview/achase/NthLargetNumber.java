package com.mo.prep.interview.achase;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NthLargetNumber {

	public static void main(String[] args) {
		
		QuickSortGeneric<Integer> intSort = new QuickSortGeneric<Integer>();
		
		Integer[] numbers = {1,8,4,5,9,7,2,10,44,55,67};
		//{1,3,5,3,7,0,20,30,15,2,100};
		int position =9;
		intSort.sort(numbers);
		System.out.println(Arrays.toString(numbers));
		System.out.println("9th Position : " + numbers[numbers.length -position]);
		System.out.println("2th Position : " + getNthLargestNumber(2,numbers));
		System.out.println("5th Position : " + getNthLargestNumber(5,numbers));
		
	}

	/**
	 * Another way of doing the same thing using collection framework
	 * @param position
	 * @param numbers
	 * @return
	 */
	public static int getNthLargestNumber(int position, Integer[] numbers){
		List<Integer> list = Arrays.asList(numbers);
		Collections.sort(list);
		return list.get(list.size()-position);
	}

}
