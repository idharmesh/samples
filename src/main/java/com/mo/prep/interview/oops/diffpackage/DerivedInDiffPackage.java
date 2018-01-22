package com.mo.prep.interview.oops.diffpackage;

import com.mo.prep.interview.oops.Base;

public class DerivedInDiffPackage extends Base {
	
	public DerivedInDiffPackage(int x) {
		super(x);
	}

	public DerivedInDiffPackage(int x,int z) {
		super(x,z);
	}

	public int getX() {
	//	return x;   // cant access as x is defined with default modifier 
		return super.getX();
	}
	
	public int getZ() {
		return z;
	}
}
