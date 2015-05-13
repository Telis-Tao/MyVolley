package com.bupt.myvolley.memory_cache;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * memory cache
 * 
 * @param <K>
 * @param <V>
 */
public class LRUCache<K, V> {
	public static final int SIZE_BASED = 1;
	public static final int NUMBER_BASED = 2;
	private int size = 0;
	private int type = 0;
	private HashMap<K, V> map;
	private Queue<K> queue;

	public LRUCache(int size) {
		this(size, NUMBER_BASED);
	}

	public LRUCache(int size, int type) {
		this.size = size;
		this.type = type;
		map = new HashMap<K, V>();
		queue = new ArrayBlockingQueue<K>(size);
	}

	public boolean containKey(K key) {
		return map.containsKey(key);
	}

	public V get(K key) {
		if (map.containsKey(key)) {
			Iterator<K> it = queue.iterator();
			while (it.hasNext()) {
				K string = it.next();
				if (string.equals(key)) {
					it.remove();
					break;
				}
			}
			queue.add(key);
		}
		return map.get(key);
	}

	public void put(K key, V value) {
		if (get(key) != null) {
			map.put(key, value);
		} else {
			if (type == NUMBER_BASED && map.size() >= size) {
				if (map.size() >= size) {
					removeEldestElement();
				}
			}
			queue.add(key);
			map.put(key, value);
		}
	}

	private void removeEldestElement() {
		K removeElement = queue.poll();
		map.remove(removeElement);
	}
}
