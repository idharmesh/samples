package com.mo.prep.interview.oops;

public class Derived extends Base {
	int x;
	String y;
	int z;
	
	public Derived(int x) {
		super(10);
		this.x = x;
		this.y = "Some String";
	}

	public int getX() {
		return x;
	}
	
	
	
}
