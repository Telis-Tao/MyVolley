package com.bupt.myvolley.thread_pool;

import com.bupt.myvolley.volley.RequestQueue;
import com.bupt.myvolley.volley.ResultListener;
import com.bupt.myvolley.volley.StringRequest;

public class Test {
	public static void main(String[] args) {
		RequestQueue queue = new RequestQueue();
		ResultListener<String> listener = new ResultListener<String>() {

			@Override
			public void onError() {
				// TODO Auto-generated method stub

			}

			@Override
			public void onResponse(Object o) {
				System.out.println(o);
			}
		};
		queue.add(new StringRequest("www.baidu.com", listener));
		queue.add(new StringRequest("www.baidu.com", listener));
		queue.add(new StringRequest("www.baidu.com", listener));
		queue.add(new StringRequest("www.baidu.com", listener));
		queue.add(new StringRequest("www.baidu.com", listener));
	}
}
