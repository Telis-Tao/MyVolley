package com.bupt.myvolley.thread_pool;

import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 目前就去实现队列线程池
 */
public class MyThreadPool {
	private int threadCount = 0;
	private int queueCount = 0;
	private Set<PoolThread> threadSet;
	private boolean isStop = false;
	private Queue<Runnable> taskQueue;

	public MyThreadPool() {
		this(5, 128);
	}

	public int getThreadSize() {
		return threadCount;
	}

	/**
	 * 这里的STOP是线程在执行完最后一个任务以后再停止,不是立即停止
	 */
	public void stop() {
		isStop = true;
	}

	public MyThreadPool(int threadCount, int queueCount) {
		this.threadCount = threadCount;
		this.queueCount = queueCount;
		taskQueue = new ArrayBlockingQueue<Runnable>(queueCount);
		threadSet = new HashSet<PoolThread>();
		for (int i = 0; i < threadCount; i++) {
			PoolThread t = new PoolThread();
			t.start();
			threadSet.add(t);
		}
	}

	public MyThreadPool(int threadCount) {
		this(threadCount, 128);
	}

	public void execute(Runnable r) {
		if (taskQueue != null) {
			synchronized (taskQueue) {
				if (taskQueue.size() >= queueCount) {
					throw new RuntimeException(
							"task number is greater than task queue size");
				}
				taskQueue.add(r);
			}
		}
	}

	private class PoolThread extends Thread {
		private Runnable runnableTmp = null;

		@Override
		public void run() {
			while (!isStop) {
				synchronized (taskQueue) {
					if (!taskQueue.isEmpty()) {
						runnableTmp = taskQueue.poll();
					}
				}
				if (runnableTmp != null) {
					runnableTmp.run();
					runnableTmp = null;
				}
			}
		}
	}
}
