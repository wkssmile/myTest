package com.keshi.mytest.core.about.pool;

public class RunnableTest implements Runnable {
	private String taskName;

	public RunnableTest(final String taskName) {
		this.taskName = taskName;
	}

	public void run() {
		// TODO Auto-generated method stub
		//System.out.println("Inside " + taskName);
		System.out.println(Thread.currentThread().getName() + "-----Inside " + taskName);
		throw new RuntimeException("RuntimeException from inside " + taskName);
	}

}
