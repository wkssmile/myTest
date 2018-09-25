package com.keshi.mytest.core.about.pool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author EDDC execute 执行指定类的对象的 run（）
 */
public class RunnableTestMain {

	public static void main(String[] args) {
		// 定义大小 线程数
		ExecutorService pool = Executors.newFixedThreadPool(5);

		/**
		 * execute(Runnable x) 没有返回值。可以执行任务，但无法判断任务是否成功完成。 execute只能执行定义大小的次数
		 */
		// pool.execute(new RunnableTest("Task1"));
		// pool.execute(new RunnableTest("Task2"));
		// pool.execute(new RunnableTest("Task3"));
		// pool.execute(new RunnableTest("Task4"));

		/**
		 * submit(Runnable x) 返回一个future。可以用这个future来判断任务是否成功完成。请看下面：
		 */
		// Future future = pool.submit(new RunnableTest("Task2"));
		//
		// try {
		// if (future.get() == null) {// 如果Future's get返回null，任务完成
		// System.out.println("任务完成");
		// }
		// } catch (InterruptedException e) {
		// } catch (ExecutionException e) {
		// // 否则我们可以看看任务失败的原因是什么
		// System.out.println(e.getCause().getMessage());
		// }

		for (int i = 0; i < 100; i++) {
			// System.out.println(pool.toString());
			pool.submit(new RunnableTest("TASK" + String.valueOf(i)));

		}

		pool.shutdown();

		while (true) {
			if (pool.isTerminated()) {
				System.out.println("易车网-口碑-抓取完成");
				break;
			} else {
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
