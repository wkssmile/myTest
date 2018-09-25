package com.keshi.mytest.core.aboutQuartz;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author Quartz是一个任务调度框架
 */
public class JobTest {
	public static void main(String[] args) {
		int r = 0 ;
		for(int i = 0;i<10000;i++) {
			boolean b = (i+2)%100==0 ;
			System.out.println(b +"========="+i);
			if(b) {
				r++;
			}
		}
		System.out.println(" --> "+r);
	}
}
