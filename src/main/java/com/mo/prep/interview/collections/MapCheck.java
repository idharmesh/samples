package com.mo.prep.interview.collections;

import java.util.HashMap;
import java.util.Map;

public class MapCheck {

	public static void main(String[] args) {
		Map<String, String> m = new HashMap<>();
		m.put("key1", "value 1");
		System.out.println(m.toString());
		m.put("key1", "Value 2");
		System.out.println(m.toString());
	}

}
