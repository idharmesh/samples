package com.mo.prep.interview.datastructure.queue;

public class QueueUsingNode<T> {
	static class Node<T>{
		T data;
		Node<T> next;
		public Node(T data) {
			this.data = data;
		}
	}
	Node<T> head, tail;
	
	public void enqueue(T item) {
		if(head == null){
			tail = new Node(item);
			head = tail;
		}
		else {
			tail.next = new Node(item);
			tail = tail.next;
		}
	}
	public T deque() {
		if(head == null)
			return null;
		T item = head.data;
		head = head.next;
		return item;
	}
	

	public static void main(String[] args) {
		QueueUsingNode<String> q = new QueueUsingNode<>();
		q.enqueue("First");
		q.enqueue("Second");
		System.out.println(q.deque());
		System.out.println(q.deque());
		System.out.println(q.deque());
	}

}
