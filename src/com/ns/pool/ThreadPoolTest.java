package com.ns.pool;

import com.ns.pool.threads.Task;

public class ThreadPoolTest {
	public static void main(String[] args) throws Exception {
		 ThreadPool threadPool=new ThreadPool(2); //create 2 threads in ThreadPool 
         Runnable task=new Task();
         threadPool.execute(task);
         threadPool.execute(task);
         
         threadPool.shutdown();
	}
}
