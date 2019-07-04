package com.ns.pool;

import com.blocking.queue.BlockingQueueCustom;
import com.blocking.queue.LinkedBlockingQueueCustom;
import com.ns.pool.threads.ThreadPoolThread;

public class ThreadPool {
	private BlockingQueueCustom<Runnable> taskQueue;

	private boolean isShutDownInitiated = false;

	public ThreadPool(int nThreads) {
		taskQueue = new LinkedBlockingQueueCustom<>(nThreads);
		for (int i = 1; i <= nThreads; i++) {
			ThreadPoolThread poolThread = new ThreadPoolThread(taskQueue, this);
			poolThread.setName("Thread: " + i);
			System.out.println("Thread: " + i + "created in thread pool");
			poolThread.start();
		}
	}

	public boolean isShutDownInitiated() {
		return this.isShutDownInitiated;
	}

	public synchronized void execute(Runnable task) throws Exception {
		if (this.isShutDownInitiated)
			throw new Exception("Pool has been shutdown no further thread will be added to pool");
		this.taskQueue.put(task);
		System.out.println("task has been added");
	}

	public synchronized void shutdown() {
		this.isShutDownInitiated = true;
		System.out.println("Shutdown is initiated");

	}
}
