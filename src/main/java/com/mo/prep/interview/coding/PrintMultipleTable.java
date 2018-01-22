package com.mo.prep.interview.coding;

public class PrintMultipleTable {

	public static void main(String[] args) {
		
		multTable(12);

	}

	private static void multTable(int n) {
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <=n; j++) {
				System.out.print(String.format("%4d", j*i));
			}
			System.out.println();
		}
	}

}
