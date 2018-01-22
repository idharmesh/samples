package com.mo.prep.interview.oops;

public class A {
	A() {
		System.out.println("Constructing A()");
		greeting();
		prints();
	}
	
	A(int z) {
		System.out.println("Constructing A(int z)");
	}
	void greeting() {
		System.out.println("instance method from A");
	}

	static void prints() {
		System.out.println("Static method from A");
	}
	
	void add() {
		System.out.println("A's add method");
	}
}