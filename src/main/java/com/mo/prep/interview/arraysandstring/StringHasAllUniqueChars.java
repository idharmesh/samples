package com.mo.prep.interview.arraysandstring;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 	Implement an algorithm to determine if a string has all unique characters. What
	if you cannot use additional data structures?
 * 	@author blossom
 *
 */
public class StringHasAllUniqueChars {
	
	//toCheck by count
	public static void listUniqChars(String s) {
		int[] apha = new int[26];
		for (int i = 0; i < s.replace(" ", "").length(); i++) {
			apha[(int) s.replace(" ", "").charAt(i) - 'a']++;
		}
		System.out.println(Arrays.toString(apha));
	}
	
	//O(n)
	public static boolean checkIfHasUniqChar(String s) {
		if(s == null)
			return false;
		boolean hasDupChar = false;
		Set<Character> cSet = new HashSet<>();
		for (Character ch : s.toCharArray()) {
			if(cSet.contains(ch)) {
				hasDupChar = true;
				break;
			}
			cSet.add(ch);
		}
		return hasDupChar;
	}
	//o(n^2)
	public static void checkIfHasUniqChars(String s) {
		boolean isUniqu = true;
		for (Character ch : s.toCharArray()) {
			if(s.indexOf(ch) != s.lastIndexOf(ch)) {
				isUniqu = false;
			}
		}
		System.out.println("Is string has all unique : " + isUniqu);
	}
	
	public static void main(String[] args) {
		String s = "and this is it";
		
		
		listUniqChars(s);
		checkIfHasUniqChars(s);
		char a = 'a';
		char z = 'z';
		char space = ' ';
		System.out.println((int) a - 'a');
		System.out.println((int) z - 'a');
		// System.out.println((int)space -'a');
		//This is another problem - replace space by %20
		replaceSpaceBy();
		System.out.println("\n ==========\n");
		System.out.println(checkIfHasUniqChar(s));
	}

	public static void replaceSpaceBy() {
		String input=  "Mr John Smith";
		//System.out.println((int)'20%');
		System.out.println(input.trim());
		char[] chars = input.trim().toCharArray();
		int spaceCount = 0;
		for (int i = 0; i < input.trim().length(); i++) {
			if (chars[i] == ' ') 
				spaceCount++;
		}
		chars = new char[input.trim().length()+(spaceCount*3)];
		replaceSpaces(chars, input.trim());
		for (int i = 0; i < chars.length; i++) {
			System.out.print(chars[i]);
		}
	}

	public static void replaceSpaces(char[] chars, String input) {
		int k = 0;
		for (int i = 0; i < input.trim().length(); i++) {
			if (input.trim().charAt(i) == ' ') {
				chars[k++] = '%';
				chars[k++] = '2';
				chars[k++] = '0';
			}
			else
				chars[k++] = input.charAt(i);
		}
	}

}
