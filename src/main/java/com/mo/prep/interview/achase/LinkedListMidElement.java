package com.mo.prep.interview.achase;

//Implements LinkedList
public class LinkedListMidElement {

	LinkedListNode getMiddleElement(LinkedListNode head) {
		LinkedListNode fast = head;
		LinkedListNode slow = head;
		
		while (fast.next != null && fast.next.next !=null){
			fast = fast.next.next;
			slow = slow.next;
		}

		if (fast.next == null)
			return slow;
		else
			return slow.next;
	}

}



 class LinkedListNode {
	 LinkedListNode head;
	 LinkedListNode next;
}