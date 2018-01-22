package com.mo.prep.interview.datastructure.stack;

public class StackDemo {

	public static void main(String[] args) {
		//One way
		Integer[] d = new Integer[10];
		NewStack<Integer> stack2 = new NewStack<Integer>(d);
		
		//another way to create instance
		NewStack<Integer> stack = new NewStack<>(10); 
		stack.push(10);
		stack.push(20);
		System.out.println(stack.pop());
		System.out.println(stack.peek());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}

}
