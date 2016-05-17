package com.schedule;

import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;
 

public class SchedulerFactory {
	private static StdSchedulerFactory schedulerFactory = null;

	
	
	
	private  static StdSchedulerFactory getScheduleFactory() {
		if (schedulerFactory == null) {
			schedulerFactory = new StdSchedulerFactory();
		}
		return schedulerFactory;
	}

	public static Scheduler getScheduler() {
		Scheduler scheduler = null;
		
		try {
			scheduler = getScheduleFactory().getScheduler();
			scheduler.start();
			   JobDetail job = JobBuilder.newJob(HelloJob.class)
			             .withIdentity("myJob")
			             .build();
			             
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return scheduler;
	}
	
	 public class HelloJob implements Job {

		    public HelloJob() {
		    }

		    public void execute(JobExecutionContext context)
		      throws JobExecutionException
		    {
		      System.err.println("Hello!  HelloJob is executing.");
		    }
		  }
}
