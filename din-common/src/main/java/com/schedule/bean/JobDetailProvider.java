package com.schedule.bean;

import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;

public class JobDetailProvider   {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String group;
	private String description;
	private JobBuilder jobBuilder;
	private Class<? extends Job> jobClass;

	public JobDetailProvider(String name,Class<? extends Job> jobClass, String group, String description) {
		super();
		this.name = name;
		this.jobClass=jobClass;
		this.group = group;
		this.description = description;
	}

	
	
	public JobDetail getJobDetail(JobDataMap jobDataMap){
		return jobBuilder.newJob(jobClass).withIdentity(name, group).usingJobData(jobDataMap).build();
	}
	
	public JobDetail getJobDetail(){
		return jobBuilder.newJob(jobClass).withIdentity(name, group).build();
	}


}
