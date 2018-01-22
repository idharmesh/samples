package com.mo.prep.interview.datastructure.linkedlist;

public class LinkedListDemo {

	public static void main(String[] args) {

		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		linkedList.insertAtHead(100);
		linkedList.insertAtHead(200);
		linkedList.insertAtHead(400);
		linkedList.insertAtHead(700);
		linkedList.insertAtHead(700);
		linkedList.insertAtHead(900);
		
		
		System.out.println("Length = " + linkedList.length());
		System.out.println("Length = " + linkedList.toString());
		System.out.println("Search 600 = " + linkedList.search(600));
		linkedList.reverse();
		System.out.println("Length = " + linkedList.toString());
		linkedList.deleteDups(linkedList.getHead());
		System.out.println("Length = " + linkedList.toString());
		
		System.out.println(linkedList.nthToLast(linkedList.getHead(),5));
		
	}

}
