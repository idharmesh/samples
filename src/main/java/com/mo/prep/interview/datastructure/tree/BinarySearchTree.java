package com.mo.prep.interview.datastructure.tree;

public class BinarySearchTree {

	private TreeNode root;
	
	public void insert(Integer data) {
		if(root == null)
			root = new TreeNode(data);
		else 
			root.insert(data);
	}
	
	public TreeNode find(Integer data) {
		if(root == null) return null;
		return root.find(data);
	}
	
	public Integer min() {
		if(root == null)
			return null;
		return root.min();
	}
	
	public Integer max() {
		if(root == null)
			return null;
		return root.max();
	}
	
	
	/* soft delete	 */
	public void delete(Integer data) {
		TreeNode node = find(data);
		node.delete();
	}
	/* Real delete
	 * 1. Lead node,
	 * 2. Node has one node
	 * 3. Node has 2 nodes
	 * 
	 */
	/*
	public void delete(Integer data) {
		TreeNode current  = root;
		TreeNode parent = root;
		boolean isLeftChild = false;
		
		if(current == null)
			return;
		
		while(current != null && current.getData() != data) {
			parent = current;
			if(data < current.getData()) {
				current = current.getLeftNode();
				isLeftChild = true;
			}
			else {
				current = current.getRightNode();
				isLeftChild = false;
			}
		}
		if(current == null)
			return;
		
		if(current.getLeftNode() == null && current.getRightNode() == null) {
			if(current == root) {
				root = null;
			}
			else {
				if(isLeftChild) {
					parent.setLeftNode(null);
				}
				else {
					parent.setRightNode(null);
				}
			}
		}
		
		if(current.getRightNode() == null) {
			if(current == root) {
				root = current.getLeftNode();
			}else if(isLeftChild) {
				parent.setLeftNode(current.getLeftNode());
			}else {
				parent.setRightNode(current.getLeftNode());
			}
		}
		if(current.getLeftNode() == null) {
			if(current == root) {
				root = current.getRightNode();
			}else if(isLeftChild) {
				parent.setLeftNode(current.getRightNode());
			}else {
				parent.setRightNode(current.getRightNode());
			}
		}
	}
	*/
	
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub

	}*/

}
