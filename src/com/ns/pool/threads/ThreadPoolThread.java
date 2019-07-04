package com.ns.pool.threads;

import com.blocking.queue.BlockingQueueCustom;
import com.ns.pool.ThreadPool;

public class ThreadPoolThread extends Thread {

	private BlockingQueueCustom<Runnable> queue;
	private ThreadPool pool;

	public ThreadPoolThread(BlockingQueueCustom<Runnable> queue, ThreadPool pool) {
		this.queue = queue;
		this.pool = pool;
	}

	@Override
	public void run() {

		try {
			while (true) {
				System.out.println(Thread.currentThread().getName() + "  Thread is ready to execute");

				Runnable runnable = queue.take();
				System.out.println(Thread.currentThread().getName() + " ha taken task");

				runnable.run();

				System.out.println(Thread.currentThread().getName() + " has executed current taks");

				if (this.pool.isShutDownInitiated() && this.queue.size() == 0) {
					this.interrupt();
					/*
					 * Interrupting basically sends a message to the thread indicating it has been
					 * interrupted but it doesn't cause a thread to stop immediately,
					 * 
					 * if sleep is called, thread immediately throws InterruptedException
					 */
					Thread.sleep(1);
				}
			}
		} catch (Exception e) {
			System.out.println(Thread.currentThread().getName() + " has been stopped");
		}
	}
}
