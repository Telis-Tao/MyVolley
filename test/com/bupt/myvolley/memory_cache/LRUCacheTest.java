package com.bupt.myvolley.memory_cache;

import junit.framework.TestCase;

public class LRUCacheTest extends TestCase {
	public void testCase0() {
		LRUCache<String, String> cache = new LRUCache<String, String>(3);
		cache.put("1", "123");
		cache.put("2", "123");
		cache.put("3", "123");
		cache.put("4", "123");
		assertEquals(null, cache.get("1"));
	}

	public void testCase1() {
		LRUCache<String, String> cache = new LRUCache<String, String>(3);
		cache.put("1", "123");
		cache.put("2", "123");
		cache.put("3", "123");
		cache.get("1");
		cache.put("4", "123");
		assertEquals("123", cache.get("1"));
		assertEquals(null, cache.get("2"));
		assertEquals("123", cache.get("3"));
		assertEquals("123", cache.get("4"));
	}
}
