package com.mo.prep.interview.collections;

import java.util.PriorityQueue;

public class PriorityQueueCheck {

	public static void main(String[] args) {
		
		PriorityQueue<Integer> priorityIntQueue = new PriorityQueue<>();
		priorityIntQueue.add(5);
		priorityIntQueue.add(4);
		priorityIntQueue.add(7);
		priorityIntQueue.add(9);
		priorityIntQueue.add(8);
		
		System.out.println(priorityIntQueue.toString());
		
		PriorityQueue<String> priorityStringQueue = new PriorityQueue<>();
		priorityStringQueue.add("a");
		priorityStringQueue.add("c");
		priorityStringQueue.add("b");
		
		System.out.println(priorityStringQueue.toString());
	}

}
