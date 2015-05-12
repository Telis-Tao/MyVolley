package com.bupt.myvolley.thread_pool;

import com.bupt.myvolley.volley.StringRequest;

public class Test {
	public static void main(String[] args) {
//		MyThreadPool threadPool = MyThreadService.getInstance(Test.class);
//		for (int i = 0; i < 10; i++) {
//			threadPool.execute(new Runnable() {
//				
//				@Override
//				public void run() {
//					// TODO Auto-generated method stub
//					System.out.println(Thread.currentThread());
//				}
//			});
//		}
//		threadPool.stop();
		StringRequest r1 = new StringRequest("www.baidu.com");
		StringRequest r2 = new StringRequest("www.baidu.com");
		StringRequest r3 = new StringRequest("www.baidu.com");
		StringRequest r4 = new StringRequest("www.baidu.com");
		StringRequest r5 = new StringRequest("www.baidu.com");
		StringRequest r6 = new StringRequest("www.baidu.com");
		System.out.println(r1.hashCode());
		System.out.println(r2.hashCode());
		MyThreadPool threadPool = MyThreadService.getInstance(Test.class);
		threadPool.execute(r1);
		threadPool.execute(r2);
		threadPool.execute(r3);
		threadPool.execute(r4);
		threadPool.execute(r5);
		threadPool.execute(r6);
	}
}
