package com.mo.prep.interview.datastructure.tree;

import java.util.Arrays;

public class CreateTreeFromOrderedArray {

	public static void main(String[] args) {
		
		Integer[] arr = new Integer[] {2,3,4,5,6,7,8,9};
		Arrays.sort(arr);
		
		//createMinHeightBST(arr,0,arr.length -1);
	}

	TreeNode2<Integer> createMinHeightBST(Integer[] arr, int start, int end) {
		if(arr == null) return null;
		int mid = (start + end)/2;
		TreeNode2<Integer> treeNode = new TreeNode2<Integer>(arr[mid]);
		treeNode.leftNode = createMinHeightBST(arr, start, mid-1);
		treeNode.rightNode = createMinHeightBST(arr, mid+1, end);
		return treeNode;
	}
	
	

}

 class TreeNode2<T> {
	
	T data;
	TreeNode2<T> leftNode;
	TreeNode2<T> rightNode;
	
	public TreeNode2(T data) {
		super();
		this.data = data;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public TreeNode2<T> getLeftNode() {
		return leftNode;
	}
	public void setLeftNode(TreeNode2<T> leftNode) {
		this.leftNode = leftNode;
	}
	public TreeNode2<T> getRightNode() {
		return rightNode;
	}
	public void setRightNode(TreeNode2<T> rightNode) {
		this.rightNode = rightNode;
	}
	
	
}
