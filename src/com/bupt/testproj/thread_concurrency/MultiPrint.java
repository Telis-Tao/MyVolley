package com.bupt.testproj.thread_concurrency;

public class MultiPrint {
	public static void main(String[] args) {
		for (int i = 0; i < 4; i++) {
			new MyThread("No." + i).start();
		}
	}

	static class MyThread extends Thread {
		private String name;

		public MyThread(String name) {
			super();
			this.name = name;
		}

		@Override
		public void run() {
			for (int i = 0; i < 5; i++) {
				System.out.print("thread: " + name);
				System.out.println();
			}
		}
	}
}
