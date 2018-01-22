package com.mo.prep.interview.arraysandstring;

public class CheckIfStringPelindrom {

	public static void main(String[] args) {
	
		String str = "madam";
		String rev = reverse(str);
		System.out.println("rev :" + rev );
		if(str.equalsIgnoreCase(rev))
			System.out.println("Pelindrom");
		else
			System.out.println("Not a Pelindrom");
		
		revX("hello");
	}

	private static String reverse(String str) {
		if(str == null || str.length() < 2)
			return str;
		return reverse(str.substring(1)) +str.charAt(0);
	}

	private static void revX(String str) {
		char[] s = str.toCharArray();
		for (int i = 0; i < s.length/2; i++) {
			char tmp = s[i];
			s[i]= s[s.length -1 - i];
			s[s.length -1 - i] = tmp;
		}
		System.out.println(new String(s));
	}
	
	
}
