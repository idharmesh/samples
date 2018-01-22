package com.mo.prep.interview.achase;

public class StringPermutations {
	public static void main(String args[]) {
		permutation("123");
	}

	/*
	 * * A method exposed to client to calculate permutation of String in Java.
	 */ public static void permutation(String input) {
		permutation("", input);
	}

	/*
	 * Recursive method which prints all permutations of given String
	 * 
	 */
	private static void permutation(String perm, String word) {
		if (word.isEmpty()) {
			System.out.println(perm + word);
		} else {
			for (int i = 0; i < word.length(); i++) {
				permutation(perm + word.charAt(i), word.substring(0, i) + word.substring(i + 1, word.length()));
			}
		}
	}
}
