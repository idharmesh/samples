package com.mo.prep.interview.coding;

public class MyFinalTest {
	public int doMethod() {
		try {
			throw new Exception();
		}
		catch(Exception e) {
			throw new Exception();
		}
		finally {
			return 10;
		}
	}

	public static void main(String[] args) {
		MyFinalTest testEx = new MyFinalTest();
		try {
			int rVal = testEx.doMethod();
			System.out.println("The return Val : " + rVal);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}

