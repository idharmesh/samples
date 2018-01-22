package com.mo.prep.interview.datastructure.tree;

public class TreeNode {
	
	private Integer data;
	private TreeNode leftNode;
	private TreeNode rightNode;
	private boolean isDeleted;
	
	public TreeNode(Integer data) {
		this.data = data;
	}
	
	public boolean isDeleted() {
		return isDeleted;
	}
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public TreeNode find(Integer data) {
		if(this.data == data && !isDeleted)
			return this;
		if(data < this.data && leftNode !=null) 
			return leftNode.find(data);
		if(rightNode != null)
			return rightNode.find(data);
		return null;
	}
	public Integer min() {
		if(this.leftNode == null)
			return this.data;
		return this.leftNode.min();
	}
	public Integer max() {
		if(this.rightNode == null)
			return this.data;
		return this.rightNode.max();
	}
	public void delete() {
		this.isDeleted = true;
	}
	
	public void insert(Integer data) {
		if(data >= this.data) {
			if(this.rightNode == null)
				this.rightNode = new TreeNode(data);
			else
				this.rightNode.insert(data);
		}else {
			if(this.leftNode == null)
				this.leftNode = new TreeNode(data);
			else
				this.leftNode.insert(data);
		}
	}
	
	public Integer getData() {
		return data;
	}
	public TreeNode getLeftNode() {
		return leftNode;
	}
	public void setLeftNode(TreeNode leftNode) {
		this.leftNode = leftNode;
	}
	public TreeNode getRightNode() {
		return rightNode;
	}
	public void setRightNode(TreeNode rightNode) {
		this.rightNode = rightNode;
	}
	
	public void add(TreeNode root, Integer data) {
		if(root ==null) return;
		if(data > root.data) {
			add(root.rightNode, data);
		}
		else if( data < root.data) {
			add(root.leftNode, data);
		}
		else
			root.data = data;
	}
	
}
