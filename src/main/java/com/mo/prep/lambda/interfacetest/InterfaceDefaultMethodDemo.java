package com.mo.prep.lambda.interfacetest;

public class InterfaceDefaultMethodDemo {

	public static void main(String[] args) {
		
		Defaulable d = DefaulableFactory.create(DefaultableImpl::new);
		System.out.println(d.notRequire());
		
		d = DefaulableFactory.create(OverridableImpl::new);
		System.out.println(d.notRequire());
	}

}
