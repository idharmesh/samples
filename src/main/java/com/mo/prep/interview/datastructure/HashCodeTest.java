package com.mo.prep.interview.datastructure;

import java.util.HashMap;

public class HashCodeTest {
	
	public static void main(String[] args) {

		HashMap<Key, String>  m = new HashMap<>();
		Key key = new Key();
		key.setSomeKey("key1");
		m.put(key, "String1");
		key = new Key();
		key.setSomeKey("key2");
		m.put(key, "String2");
		key = new Key();
		key.setSomeKey("key3");
		m.put(key, "String3");
		
		
		//Since you have not implemented the hashcode method, this does not returns anything
		// as it uses default hashcode which is nothing but a memory address of the object in hexa decimal format
		
		key = new Key();
		key.setSomeKey("key2");
		System.out.println(m.get(key));
		
		Integer x = 10;
		Integer y = 12;
		System.out.println("Pre Swap-"+x +","+y);
		swap(x,y);
		System.out.println("Post Swap-"+x +","+y);
		
		//To see result, simply override hashcode and you will see String2 as an output
	}
	
	static void swap(Integer x, Integer y) {
		x = x^y;
		y = x^y;
		x = x^y;
		System.out.println("In swap-"+x +","+y);
	}

}
class Key{
	String someKey;
	public String getSomeKey() {
		return someKey;
	}

	public void setSomeKey(String someKey) {
		this.someKey = someKey;
	}

	

	
	
	
}