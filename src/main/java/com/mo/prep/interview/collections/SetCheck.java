package com.mo.prep.interview.collections;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class SetCheck {

	public static void main(String[] args) {
		
		Set<String> setOfString = new TreeSet<>();
		setOfString.add("dharmesh");
		setOfString.add("Niku");
		setOfString.add("blossom");
		//setOfString.add(null);
		
		System.out.println(setOfString.toString());
		
		//An ignoreCase comparator
		setOfString = new TreeSet<>(stringComparator);
		setOfString.add("dharmesh");
		setOfString.add("Niku");
		setOfString.add("blossom");
		
		System.out.println(setOfString.toString());
		
		setOfString = new LinkedHashSet<>();
		setOfString.add(null);
		
		System.out.println(setOfString.toString());
		
		
		NavigableSet<String> navigable = new TreeSet<>();
		//navigable.add(null);
		System.out.println(navigable.toString());
		
		
		Set<String> hashSet = new HashSet<>();
		hashSet.add(null);
		System.out.println(hashSet.toString());
		
	}
	
	static Comparator<String> stringComparator = new Comparator<String>() {
		
		@Override
		public int compare(String o1, String o2) {
			return o1.compareToIgnoreCase(o2);
		}
	};

}
