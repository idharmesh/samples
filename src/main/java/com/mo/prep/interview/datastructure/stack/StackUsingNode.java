package com.mo.prep.interview.datastructure.stack;

public class StackUsingNode<T> {
	static class Node<T> {
		T data;
		Node<T> next;
		Node(T data) {
			this.data = data;
		}
	}
	Node<T> top;
	
	public void push(T item) {
		Node<T> t = new Node<T>(item);
		t.next = top;
		top = t;
	}
	
	public T pop() {
		if(top != null ) {
			T item = top.data;
			top = top.next;
			return item;
		}
		return null;
	}
	
	public T peek() {
		if(top != null) {
			return top.data;
		}
		return null;
	}

	
	public static void main(String[] args) {
		StackUsingNode<String> stack = new StackUsingNode<>();
		stack.push("First");
		stack.push("Second");
		stack.push("Third");
		System.out.println(stack.peek());
		System.out.println("\n ========== \n");
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}

}
