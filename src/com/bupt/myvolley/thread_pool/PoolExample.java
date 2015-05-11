package com.bupt.myvolley.thread_pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PoolExample {
	public static void main(String[] args) {
		ExecutorService pool = Executors.newCachedThreadPool();
		Runnable command = null;
		pool.execute(command);
	}
}
