package com.mo.prep.interview.datastructure.stack;

import java.util.ArrayList;
import java.util.List;

public class SetOfStack<T> {
	
	int capacity = 0;
	List<Stack<T>> setOfStack = new ArrayList<>();
	
	public SetOfStack(int capacity) {
		this.capacity = capacity;
		addStack(capacity);
	}

	private void addStack(int capacity) {
		Stack<T> stack = new Stack<>(capacity);
		setOfStack.add(setOfStack.size(), stack);
	}
	
	public void push(T data){
		if((setOfStack.get(setOfStack.size())).top == capacity -1)
			addStack(capacity);;
		setOfStack.get(setOfStack.size()).push(data);
	}
	public T pop(T data){
		if((setOfStack.get(setOfStack.size())).top == -1)
			setOfStack.remove(setOfStack.size());
		return setOfStack.get(setOfStack.size()).pop();
	}

	public static void main(String[] args) {

		SetOfStack<Integer> set = new SetOfStack<Integer>(10);
		System.out.println(set.setOfStack.size());
	}

}
