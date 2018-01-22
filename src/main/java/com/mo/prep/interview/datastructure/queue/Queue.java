package com.mo.prep.interview.datastructure.queue;

public class Queue<T> {
	
	T data[];
	int head = -1;
	int tail = -1;
	
	public Queue(T[] data) {
		this.data = data;
	}
	
	public void enque(T element) {
		if(tail > data.length) {
			System.out.println("Sorry queue is full..");
			return;
		}
		if(head == -1) {
			data[++head] = element; 
			tail = head;
		}
		else {
			data[++tail] = element;
		}
	}
	
	public T deque(){
		if(head >= data.length){
			System.out.println("Sorry, queue is empty.");
			return null;
		}
		return data[head++];
	}
	
	public T peek(){
		if(tail < 0){
			System.out.println("Sorry, queue is empty.");
			return null;
		}
		return data[head];
	}
	
	
	public static void main(String[] args) {
		Integer arr[] = new Integer[3];
		Queue<Integer> queue = new Queue<>(arr);
		queue.enque(12);
		queue.enque(15);
		System.out.println(queue.peek());
		queue.enque(25);
		System.out.println(queue.deque());
		System.out.println(queue.deque());
		System.out.println(queue.peek());
		System.out.println(queue.deque());
		System.out.println(queue.deque());
	}

}
