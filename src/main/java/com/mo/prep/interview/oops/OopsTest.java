package com.mo.prep.interview.oops;

public class OopsTest {

	public static void main(String[] args) {
		Base b = new Derived(20);
		System.out.println(b.getX());
		b.someInterfaceMethod();
		
		//Though b is base, as cast to Derived, refers Derived's Y
		System.out.println(((Derived)b).y);
		
		DerivedTwo two = new DerivedTwo(67);
		System.out.println(two.getX());
		
	}

}
