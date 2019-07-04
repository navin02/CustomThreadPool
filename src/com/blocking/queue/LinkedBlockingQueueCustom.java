package com.blocking.queue;

import java.util.LinkedList;
import java.util.List;

public class LinkedBlockingQueueCustom<E> implements BlockingQueueCustom<E> {
	private List<E> queue;
	private int maxSize;

	public LinkedBlockingQueueCustom(int maxSize) {
		this.maxSize = maxSize;
		this.queue = new LinkedList<E>();
	}

	@Override
	public synchronized void put(E elemet) throws InterruptedException {
		if (this.queue.size() == maxSize) {
			this.wait();
		}
		this.queue.add(elemet);
		this.notifyAll();
	}

	@Override
	public synchronized E take() throws InterruptedException {
		if (this.queue.size() == 0) {
			this.wait();
		}
		this.notifyAll();
		return this.queue.remove(0);
	}

	public synchronized int size() {
		return this.queue.size();
	}
}
