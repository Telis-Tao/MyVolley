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
	private Thread daemonThread;
	private boolean isDaemonThreadStop = false;

	public RequestQueue() {
		mThreadPool = MyThreadService.getInstance(getClass());
		cache = new LRUCache<BasicRequest<?>, Object>(16);
		list = new ArrayList<BasicRequest<?>>();
		daemonThread = new DaemonThread();
		daemonThread.start();
	}

	public void finish() {
		mThreadPool.stop();
		stopDaemonThread();
	}

	private void stopDaemonThread() {
		isDaemonThreadStop = true;
	}

	public void add(BasicRequest<?> request) {
		request.setCache(cache);
		if (cache != null) {
			if (cache.containKey(request)) {
				if (cache.get(request) == null) {
					list.add(request);
				} else {
					request.listener.onResponse(cache.get(request));
				}
				return;
			}
		}
		mThreadPool.execute(request);
		cache.put(request, null);
	}

	private class DaemonThread extends Thread {
		@Override
		public void run() {
			while (!isDaemonThreadStop) {
				if (!list.isEmpty()) {
					for (int i = 0; i < list.size(); i++) {
						BasicRequest<?> request = list.get(i);
						if (cache.get(request) != null) {
							System.out.println("------------ cacahe -------------");
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
