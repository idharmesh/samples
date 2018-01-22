/**
 * 
 */
package com.mo.prep.interview.coding;

import java.util.Stack;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * @author blossom
 *
 */
public class RevserseStackUsingQueue {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Stack<String> s = new Stack<>();
		s.push("a");
		s.push("b");
		s.push("c");
		System.out.println(Arrays.toString(s.toArray()));
		reverseStack(s);
		System.out.println(Arrays.toString(s.toArray()));
	}

	private static void reverseStack(Stack<String> s) {
		Queue<String> q = new ArrayDeque<>();
 		while(!s.isEmpty()){
			q.add(s.pop());
		}
		
		while(!q.isEmpty()) {
			s.push(q.poll());
		}
	}

}
