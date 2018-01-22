package com.mo.prep.interview.singleton;

public class SingletonUsingEnumTest {
	
	public static void main(String[] args) {
		SingletonUsingEnum.INSTANCE.calculate(10, 2);
		SingletonUsingStatic.getInstance().calculate(30, 2);
	}
}
