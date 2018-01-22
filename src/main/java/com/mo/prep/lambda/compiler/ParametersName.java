package com.mo.prep.lambda.compiler;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ParametersName {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		
		Method method = ParametersName.class.getMethod("main", String[].class);
		for (final Parameter parameter : method.getParameters()) {
			System.out.println("Paramter: " + parameter.getName());
			
		}
	}

}
