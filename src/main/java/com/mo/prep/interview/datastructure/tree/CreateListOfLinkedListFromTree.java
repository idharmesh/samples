package com.mo.prep.interview.datastructure.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class CreateListOfLinkedListFromTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		List<LinkedList<TreeNode>> lists = new ArrayList<>();
		
		createList(root, lists, 0);
		
	}

	private static void createList(TreeNode root, List<LinkedList<TreeNode>> lists, int level) {
		if(root  == null) return;
		LinkedList<TreeNode> list = null;
		if(lists.size() == level) {
			list = new LinkedList<>();
			lists.add(list);
		}
		else {
			list = lists.get(level);
		}
		list.add(root);
		createList(root.getLeftNode(), lists, level + 1);
		createList(root.getRightNode(), lists, level + 1);
	}

}
