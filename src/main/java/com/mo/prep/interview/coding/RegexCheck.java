package com.mo.prep.interview.coding;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexCheck {

	public static void main(String[] args) {
		String s = "This is a Bloomberg's Java8    question score 345 &with \t $100 worth.\n";
		Pattern p = Pattern.compile("\\d");
		//Matcher m = p.matcher(s);
		//System.out.println(m.group());
		
		System.out.println(3|5);
	}

}
