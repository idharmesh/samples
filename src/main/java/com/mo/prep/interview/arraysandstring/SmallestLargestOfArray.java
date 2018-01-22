package com.mo.prep.interview.arraysandstring;

public class SmallestLargestOfArray {

	public static void main(String[] args) {
		int[] salaries = { 1000, 5000, 2000, 6000, 3000 };
		int largest = findLargest(salaries);
		System.out.println("Largest salary:" + largest);
		int smallest = findSmallest(salaries);
		System.out.println("Smallest salary: " + smallest);
		int index = searchSalary(2000, salaries);
		System.out.println("Salary " + salaries[index] + " at index: " + index);
	}

	public static int findLargest(int[] salaries) {
		int largest = salaries[0];
		for (int i = 0; i < salaries.length; i++) {
			if (salaries[i] > largest) {
				largest = salaries[i];
			} // end if
		} // end for
		return largest;
	}// end findlargest

	public static int findSmallest(int[] salaries) {
		int smallest = salaries[0];
		for (int i = 0; i < salaries.length; i++) {
			if (salaries[i] < smallest) {
				smallest = salaries[i];

			} // end if

		} // end for
		return smallest;
	}// end findsmallest

	public static int searchSalary(int salary, int[] salaries) {
		int index = -1;
		for (int i = 0; i < salaries.length; i++) {
			if (salary == salaries[i]) {
				index = i;
				break;
			} // end if

		} // end for
		return index;
	}// end searchsalary
}
