package com.mo.prep.interview.oops.diffpackage;

 class A {
	void add() {
		System.out.println("Add A");
	}
}

class B extends A {
	void add() {
		System.out.println("Add B");
	}
}

public class C extends B {
	void add() {
		System.out.println("Add C");
	}

	public static void main(String[] args) {
		B foo = new C();
		foo.add();
	}
}
