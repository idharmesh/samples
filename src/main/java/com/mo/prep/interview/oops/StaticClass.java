package com.mo.prep.interview.oops;

public class StaticClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SomeStaticClass.someMethod();
		StaticClass classObj = null;
		classObj.someOuerMethod();
	}
	
	static void someOuerMethod() {
		System.out.println("Some outer method");
	}
	
	
	static class SomeStaticClass implements BaseInterface {

		@Override
		public void someInterfaceMethod() {
			// TODO Auto-generated method stub
			
		}
		
		static void someMethod() {
			System.out.println("Some method");
		}
		
	}
}



