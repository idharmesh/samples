package com.mo.prep.interview.sorting;

public class FindASingleOddNumber {
	private int[] array = {1,1,2,3,4,5,2,3,4};
	public static void main(String[] args) {
		FindASingleOddNumber test = new FindASingleOddNumber();
		int singleOdd = test.findSingleOdd();
		System.out.println("singleOdd = " + singleOdd);
	}

	private int findSingleOdd() {
		int result = 0;
		for (int i : array) {
			result = result ^i;
		}
		return result;
	}

}
