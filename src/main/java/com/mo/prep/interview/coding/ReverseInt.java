package com.mo.prep.interview.coding;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.WeakHashMap;

public class ReverseInt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Long l = 50L;
		byte[] b = new byte[]{1,2,3};
		System.out.println(new String(b));
		//Long fromByte = new Long();
		System.out.println(l.hashCode());
		System.out.println((int)(l ^ (l >>> 32)));
		System.out.println(50^(50>>>32));
		Long val = new Long("200");
		System.out.println(val);
		Integer ival = new Integer("300");
		System.out.println(ival);
/*		int num = 10020;
		int rev = reverse(num);
		System.out.println("Rev("+ num +") : " + rev);
		System.out.println("Rev("+ num +") : " + reverseAsStr(num));
*/
		int i = 1024;
		byte byt = (byte) i;
		System.out.println(byt);
		
		byt = 120;
		i = 10;
		byt += i;
		System.out.println(byt);
		System.out.println(3*0.1 == 0.3);
				
		WeakHashMap<String, String>  w = new WeakHashMap<>();
		w.putIfAbsent("key", "Value");
		
		System.out.println(w.toString());
		
		//Set<String> set = new HashSet<>();
		SortedSet<String> set = new TreeSet<>(); 
		for (int j = 0; j < 10; j++) {
			
			set.add("xzyetssomeString"+j);
		}
		System.out.println(set.size());
		System.out.println(set.toString());
	
	
		
		
	}

	private static int reverse(int i) {
		
		if(i < 1)
			return i;
		int rev = 0;
		int lastDigit = 0;
		while(i > 0) {
			lastDigit = i%10;
			rev = rev*10 + lastDigit;
			i = i/10;
		}
		return rev;
	}

	private static String reverseAsStr(int i) {
			
			if(i < 1)
				return i+"";
			int rev = 0;
			String res = "";
			int lastDigit = 0;
			while(i > 0) {
				lastDigit = i%10;
				rev = rev*10 ;
				res += rev + lastDigit;
				i = i/10;
			}
			return res;
		}
	}
