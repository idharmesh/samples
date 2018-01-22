package com.mo.prep.interview.datastructure.stack;

import java.util.Arrays;

public class NewStack<T> {
	T data[] = (T[]) new Object[1];
	int top = -1;
	public NewStack(T[] data) {
		this.data = data;
	}
	
	public NewStack(int capacity) {
		data = newArray(capacity, data);
	}
	
	static <T> T[] newArray(int capacity, T... array) {
		return Arrays.copyOf(array, capacity);
	}
	
	
	public void push(T element){
		if(top >= data.length) {
			System.out.println("Sorry stack is full ..");
			return;
		}
		data[++top] = element;
	}
	public T pop() {
		
		if(top < 0) {
			System.out.println("Sorry stack is empty ..");
			return null;
		}
		return data[top--];
	}
	
	public T peek(){
		if(top < 0) {
			System.out.println("Sorry stack is empty ..");
			return null;
		}
		return data[top];
	}
}
