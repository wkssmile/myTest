package com.keshi.mytest.core.about.pool;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable {
	private BlockingQueue<String> queue;
	private static final int DEFAULT_RANGE_FOR_SLEEP = 1000;

	public Consumer(BlockingQueue<String> queue) {
		this.queue = queue;
	}

	public void run() {
		// TODO Auto-generated method stub
		System.out.println("启动消费者线程！" + "consumer当前线程：" + Thread.currentThread().getName());
		Random r = new Random();
		boolean isRunning = true;
		try {
			while (isRunning) {
				System.out.println("正从队列获取数据..." + "consumer当前线程：" + Thread.currentThread().getName());
				/*
				 * 　poll(long timeout, TimeUnit unit)：从BlockingQueue取出一个队首的对象，如果在指定时间内，
　　　　队列一旦有数据可取，则立即返回队列中的数据。否则知道时间超时还没有数据可取，返回失败。
				 */
				String data = queue.poll(2, TimeUnit.SECONDS);
				if (null != data) {
					System.out.println("拿到数据：" + data + "consumer当前线程：" + Thread.currentThread().getName());
					System.out.println("正在消费数据：" + data + "consumer当前线程：" + Thread.currentThread().getName());
					Thread.sleep(r.nextInt(DEFAULT_RANGE_FOR_SLEEP));
				} else {
					// 超过2s还没数据，认为所有生产线程都已经退出，自动退出消费线程。
					isRunning = false;
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		} finally {
			System.out.println("退出消费者线程！" + "consumer当前线程：" + Thread.currentThread().getName());
		}

	}

}
