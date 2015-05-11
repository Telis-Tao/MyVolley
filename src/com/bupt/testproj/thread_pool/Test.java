package com.bupt.testproj.thread_pool;

public class Test {
	public static void main(String[] args) {
		MyThreadPool threadPool = MyThreadService.getInstance(Test.class);
		for (int i = 0; i < 10; i++) {
			threadPool.execute(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					System.out.println(Thread.currentThread());
				}
			});
		}
		threadPool.stop();
	}
}
