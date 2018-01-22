package com.mo.prep.interview.oops;

public class C extends B {
	C(){
	}
	void add() {
		super.add();
		//System.out.println("C's add method");
	}
	public static void main(String[] args) {
		B b = new B();
		A c = new C();
		c.add();
		C newc = (C)b;
	}
	
	

}