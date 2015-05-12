package com.bupt.myvolley.volley;

import java.util.ArrayList;
import java.util.List;

import com.bupt.myvolley.memory_cache.LRUCache;
import com.bupt.myvolley.thread_pool.MyThreadPool;
import com.bupt.myvolley.thread_pool.MyThreadService;

public class RequestQueue {
	private MyThreadPool mThreadPool = null;
	private LRUCache<BasicRequest<?>, Object> cache;
	private List<BasicRequest<?>> list;

	public RequestQueue() {
		mThreadPool = MyThreadService.getInstance(getClass());
		cache = new LRUCache<BasicRequest<?>, Object>(16);
		list = new ArrayList<BasicRequest<?>>();
		new daemonThread().start();
	}

	public void add(final BasicRequest<?> request) {
		if (cache != null) {
			Object o = null;
			if (cache.containKey(request)) {
				if (cache.get(request) == null) {
					list.add(request);
				}
				request.listener.onResponse(o);
				return;
			}
		}
		mThreadPool.execute(request);
	}

	private class daemonThread extends Thread {
		@Override
		public void run() {
			while (true) {
				if (!list.isEmpty()) {
					for (int i = 0; i < list.size(); i++) {
						BasicRequest<?> request = list.get(i);
						if (cache.get(request) != null) {
							request.listener.onResponse(cache.get(request));
						}
					}
					for (int i = 0; i < list.size(); i++) {
						BasicRequest<?> request = list.get(i);
						if (cache.get(request) != null) {
							list.remove(i--);
						}
					}
				}
			}
		}
	}
}
