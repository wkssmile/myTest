package com.keshi.mytest.core.about.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class DoNothingJob implements Job {

	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("do nothing");

	}

}
