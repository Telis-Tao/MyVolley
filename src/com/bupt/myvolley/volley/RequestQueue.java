package com.bupt.myvolley.volley;

import com.bupt.myvolley.thread_pool.MyThreadPool;
import com.bupt.myvolley.thread_pool.MyThreadService;

public class RequestQueue {
	private MyThreadPool mThreadPool = null;

	public RequestQueue() {
		mThreadPool = MyThreadService.getInstance(getClass());
	}

	public void add(final BasicRequest request) {
		mThreadPool.execute(new Runnable() {

			@Override
			public void run() {
				request.openConnection();
			}
		});
	}
}
