/**
 * 
 */
package com.mo.prep.interview.lrucache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author blossom
 * 
 * Implementation of LRU Cache using LinkedHashMap
 * 
 * Funda is to use LinkedHashMap's  removeEldestEntry method
 *
 */
@SuppressWarnings("serial")
public class LRUCache<K, V> extends LinkedHashMap<K, V> {

	int cacheSize;

	public LRUCache(int cacheSize) {
		this.cacheSize = cacheSize;
	}

	@Override
	protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
		return size() > cacheSize;
	}
	
	public static void main(String[] args) {
		LRUCache<Integer, Integer> cache = new LRUCache<>(5);
		for (int i = 0; i < 8; i++) {
			cache.put(i, i);
		}
		
		System.out.println(cache.toString());
	}
}
