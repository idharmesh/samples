package com.mo.prep.interview.datastructure.stack;

import java.util.Stack;
public class SortingStack {

	public static void main(String[] args) {
		Stack<Integer> s1 = new Stack<>();
		s1.push(2);
		s1.push(1);
		s1.push(4);
		s1.push(3);
		System.out.println(sort(s1).toString());
		
	}
	
	public static Stack<Integer> sort(Stack<Integer> s) {
		Stack<Integer> r = new Stack<>();
		while (!s.isEmpty()) {
			int tmp = s.pop();
			while(!r.isEmpty() && r.peek() > tmp) {
				s.push(r.pop());
			}
			r.push(tmp);
		}
		return r;
	}

}

