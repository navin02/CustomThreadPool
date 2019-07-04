package com.blocking.queue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestQueue {
	public static void main(String[] args) throws InterruptedException {
		LinkedBlockingQueueCustom<Integer> customBlockingQueue = new LinkedBlockingQueueCustom<Integer>(2);
		customBlockingQueue.put(11);
		customBlockingQueue.put(12);
		// customBlockingQueue.put(13);
		// System.out.println(customBlockingQueue.size());
		// System.out.println(customBlockingQueue.take());
		System.out.println(customBlockingQueue.size());

		ExecutorService executorService = Executors.newFixedThreadPool(5);
		//executorService.execute(command);
	}
}
