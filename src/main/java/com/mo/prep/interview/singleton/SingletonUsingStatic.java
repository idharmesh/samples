package com.mo.prep.interview.singleton;

public class SingletonUsingStatic {
	private static SingletonUsingStatic INSTANCE = new SingletonUsingStatic();
	
	private SingletonUsingStatic() {
		
	}
	public static SingletonUsingStatic getInstance() {
		return INSTANCE;
	}
	
	public void calculate(int i, int j) {
		System.out.println("Multipl = "  + (i*j));
	}
}
