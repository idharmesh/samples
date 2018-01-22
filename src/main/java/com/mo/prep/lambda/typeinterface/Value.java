package com.mo.prep.lambda.typeinterface;

public class Value<T> {
	
	public static<T> T defaultValue() {
		return (T) "100";
	}
	
	public T getOrDefaultValue(T value,T defaultValue){
		return value!=null?value:defaultValue;
	}
}
