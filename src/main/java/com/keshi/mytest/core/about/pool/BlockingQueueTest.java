package com.keshi.mytest.core.about.pool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * main 一个线程0
 * producer1 一个线程1
 * producer2 一个线程2
 * producer3 一个线程3
 * consumer 一个线程4
 * producer 负责往queue里放
 * consumer 负责从queue里取
 */
public class BlockingQueueTest {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("main当前线程：" + Thread.currentThread().getName());

		// 声明一个容量为10的缓存队列
		BlockingQueue<String> queue = new LinkedBlockingQueue<String>(10);

		Producer producer1 = new Producer(queue);
		Producer producer2 = new Producer(queue);
		Producer producer3 = new Producer(queue);
		Consumer consumer = new Consumer(queue);

		// 借助Executors
		ExecutorService service = Executors.newCachedThreadPool();
		// 启动线程
		service.execute(producer1);
		service.execute(producer2);
		service.execute(producer3);
		service.execute(consumer);

		// 执行10s
		System.out.println("10s");
		Thread.sleep(10 * 1000);
		producer1.stop();
		producer2.stop();
		producer3.stop();

		Thread.sleep(2000);
		// 退出Executor
		service.shutdown();
	}
}
