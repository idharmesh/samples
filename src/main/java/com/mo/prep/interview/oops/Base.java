/**
 * 
 */
package com.mo.prep.interview.oops;

/**
 * @author blossom
 *
 */
public class Base implements BaseInterface {
	int x;
	double y;
	protected int z;
	public Base(int x) {
		this.x = x;
		y = Math.random();
	}

	public Base(int x,int z) {
		this.x = x;
		this.z = z;
	}

	public int getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public int getZ() {
		return z;
	}
	
	//Good to mark as override, however it is not mandatory
	@Override
	public void someInterfaceMethod() {
		System.out.println("Some method impl in Base which is defined in Interface ");
	}
	
}
