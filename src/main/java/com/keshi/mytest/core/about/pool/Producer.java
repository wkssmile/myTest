package com.keshi.mytest.core.about.pool;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable {

	private volatile boolean isRunning = true;
	private BlockingQueue queue;
	private static AtomicInteger count = new AtomicInteger();
	private static final int DEFAULT_RANGE_FOR_SLEEP = 1000;

	public Producer(BlockingQueue queue) {
		this.queue = queue;
	}

	public void run() {
		// TODO Auto-generated method stub
		String data = null;
		Random r = new Random();

		System.out.println("启动生产者线程！" + "producer当前线程：" + Thread.currentThread().getName());
		try {
			while (isRunning) {
				System.out.println("正在生产数据..." + "producer当前线程：" + Thread.currentThread().getName());
				Thread.sleep(r.nextInt(DEFAULT_RANGE_FOR_SLEEP));

				data = "data:" + count.incrementAndGet();
				System.out.println("将数据：" + data + "放入队列..." + "producer当前线程：" + Thread.currentThread().getName());
				/*
				 * 　offer(E o, long timeout, TimeUnit unit),可以设定等待的时间，如果在指定的时间内，还不能往队列中
　　　　加入BlockingQueue，则返回失败。
				 */
				if (!queue.offer(data, 2, TimeUnit.SECONDS)) {
					System.out.println("放入数据失败：" + data + "producer当前线程：" + Thread.currentThread().getName());
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		} finally {
			System.out.println("退出生产者线程！" + "producer当前线程：" + Thread.currentThread().getName());
		}
	}

	public void stop() {
		isRunning = false;
	}
}
