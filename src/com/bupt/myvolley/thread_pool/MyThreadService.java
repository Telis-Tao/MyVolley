package com.bupt.myvolley.thread_pool;

import java.util.HashMap;

public class MyThreadService {
	private static HashMap<Class<?>, MyThreadPool> poolMap = new HashMap<Class<?>, MyThreadPool>();

	public static MyThreadPool getInstance(Class<?> clz) {
		MyThreadPool mThreadPool = null;
		if (poolMap.containsKey(clz)) {
			mThreadPool = poolMap.get(Thread.currentThread());
		} else {
			mThreadPool = new MyThreadPool();
			poolMap.put(clz, mThreadPool);
		}
		return mThreadPool;
	}

	public static void stop(Class<?> clz) {
		if (!poolMap.containsKey(clz)) {
			throw new RuntimeException("can't stop target ThreadPool in current thread");
		}
		poolMap.get(clz).stop();
	}
}
