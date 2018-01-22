package com.mo.prep.interview.oops;

public class B extends A {
	/* this will only call A(int z) const and not the default one.
	 B(){
		super(1);
		System.out.println("Constructing B()");
		//greeting();
		//prints();
	}
	*/
	B(){
		System.out.println("Constructing B()");
		greeting();
		prints();
	}
	void greeting() {
		System.out.println("instance method from B");
	}

	static void prints() {
		System.out.println("Static method from B");
	}


	public static void main(String[] args) {
		new B();
	}
	
	void add() {
		super.add();
		//System.out.println("B's add method");
	}

}

