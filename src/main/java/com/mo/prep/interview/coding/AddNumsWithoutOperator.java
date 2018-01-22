package com.mo.prep.interview.coding;

public class AddNumsWithoutOperator {

	public static void main(String[] args) {
		
		int sum = sumInt(11,15);
		System.out.println("Sum= " + sum);
	}

	private static int sumInt(int a, int b) {
		if(b==0) 
			return a;
		else
			return sumInt(a^b, (a&b)<< 1);
	}
	

}
