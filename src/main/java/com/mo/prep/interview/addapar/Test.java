package com.mo.prep.interview.addapar;

import java.text.DecimalFormat;

public class Test {
	static DecimalFormat doubleFormater = new DecimalFormat("#0.##");
	public static void main(String[] args) {
		System.out.println(doubleFormater.format(100.75));

	}

}
