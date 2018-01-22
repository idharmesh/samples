package com.mo.prep.interview.coding;

public class StaticInitializer {
	
	static int i=0;
	static
	{
		i = 1;
		System.out.println("This is sysout from static initializer block!");
	}
	
	public static void someStaticMethod() {
		System.out.println("Sysout from static method..");
	}
	public static void main(String[] args) {
		//System.out.println("i = " + i);
		StaticInitializer obj = new StaticInitializer();
		obj = new StaticInitializer();
		/*obj = new StaticInitializer();
		obj.someStaticMethod();*/
	}

}
