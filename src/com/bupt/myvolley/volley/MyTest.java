package com.bupt.myvolley.volley;

import com.bupt.myvolley.beans.BaiduMapResponse;

public class MyTest {
	public static void main(String[] args) {
		// Queue<String> queue = new ArrayBlockingQueue<String>(12);
		// System.out.println(queue.isEmpty());
		// System.out.println(queue.poll());
		RequestQueue queue = new RequestQueue();
		queue.add(new BaiduMapRequest(
				"http://api.map.baidu.com/place/v2/search?query=����&region=����&output=json&ak=a09j7xFDtXLble7gWeUqP1NH",
				new ResultListener() {

					@Override
					public void onResponse(Object o) {
						System.out.println((BaiduMapResponse) o);
					}

					@Override
					public void onError() {

					}
				}));
		// queue.add(new BaiduMapRequest(
		// "http://api.map.baidu.com/place/v2/search?query=����&region=����&output=json&ak=a09j7xFDtXLble7gWeUqP1NH"));
	}
}
