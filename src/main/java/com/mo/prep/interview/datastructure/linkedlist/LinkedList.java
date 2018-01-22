/**
 * 
 */
package com.mo.prep.interview.datastructure.linkedlist;

import java.util.Hashtable;

/**
 * @author blossom
 *
 */
public class LinkedList<T> {
	private Node<T> head;

	//nth element from the last  - using recursive
	public int nthToLast(Node<T> head, int k) {
		if(head == null) return 0;
		int i = nthToLast(head.next, k) + 1;
		if(i ==k) 
			System.out.println(head.data);
		return i;
	}
	public void deleteDups(Node<T> node){
		Node nextNode = null;
		Hashtable<T, Boolean> ht = new Hashtable<>();
		while(node != null) {
			if(ht.contains(node.data)){
				nextNode = nextNode.next;
			}
			else{
				ht.put((T)node.data, true);
				nextNode = node;
			}
			node = node.next; 
		}
	}
	public void insertAtHead(T data) {
		Node<T> newNode = new Node<T>(data);
		if (head != null) {
			newNode.setNext(this.head);
			System.out.println("Duplicate : " + this.head);
			this.head = newNode;
		} else {
			this.head = newNode;
		}
	}

	public Node<T> getHead() {
		return this.head;
	}

	
	public void reverse() {
		Node<T> prevNode = null;
		Node<T> currentNode = head;
		Node<T> nextNode;
		while(currentNode != null) {
			nextNode = currentNode.next;
			currentNode.next = prevNode;
			prevNode = currentNode;
			currentNode = nextNode;
		}
		head = prevNode;
	}

	public int length() {
		if (this.head == null)
			return 0;
		Node<T> current = this.head;
		int i = 0;
		while (current != null) {
			i++;
			current = current.getNext();
		}
		return i;
	}

	public T search(T query) {
		if (this.head == null)
			return null;
		Node<T> current = this.head;
		while (current != null) {
			if (current.getData().equals(query))
				return current.getData();
			current = current.getNext();
		}
		return null;
	}

	@Override
	public String toString() {
		if (this.head == null)
			return null;

		Node<T> current = this.head;
		StringBuilder data = new StringBuilder("{ ");
		while (current != null) {
			data.append(" " + current.getData() + ",");
			current = current.getNext();
		}
		data.append(" }");
		return data.toString();
	}

	@SuppressWarnings("unused")
	private static class Node<T> {
		private T data;
		private Node<T> next;

		public Node(T data) {
			this.data = data;
		}

		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}

		public Node<T> getNext() {
			return next;
		}

		public void setNext(Node<T> next) {
			this.next = next;
		}

		@Override
		public String toString() {
			return "data=" + data + " ";
		}

	}
}
