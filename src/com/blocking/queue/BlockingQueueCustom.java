package com.blocking.queue;

public interface BlockingQueueCustom<E> {

	public void put(E elemet) throws InterruptedException;

	E take() throws InterruptedException;

	public int size();
}
