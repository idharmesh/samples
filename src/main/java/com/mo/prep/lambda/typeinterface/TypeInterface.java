package com.mo.prep.lambda.typeinterface;

public class TypeInterface {

	public static void main(String[] args) {
		final Value<String> value = new Value<>();
		System.out.println(value.getOrDefaultValue(null, Value.defaultValue()));
	}

}
