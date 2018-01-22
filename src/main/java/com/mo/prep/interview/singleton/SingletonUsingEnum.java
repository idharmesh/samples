package com.mo.prep.interview.singleton;

public enum SingletonUsingEnum {
	INSTANCE;
	
	public void calculate(int i, int j) {
		System.out.println("Multipl = "  + (i*j));
	}
}
