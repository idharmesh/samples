package com.mo.prep.interview.datastructure.stack;

import java.util.Arrays;

public class Stack<T> {

	
	int capacity = 0;
	@SuppressWarnings("unchecked")
	T[] data = (T[]) new Object[1];
	int top = -1;
	
	public Stack(int capacity) {
		data = newArray(capacity, data);
	}
	
	@SafeVarargs
	static <T> T[] newArray(int capacity, T... array) {
		return Arrays.copyOf(array, capacity);
	}
	
	public void push(T data) {
		if(top < this.data.length)
			this.data[++top] = data;
		else
			System.out.println("You can not inter more element in the stack");
	}
	
	public T pop () {
		if(top < 0)
			return null;
		return this.data[top--];
	}
	
	public T peek() {
		return this.data[top];
	}
	
}
