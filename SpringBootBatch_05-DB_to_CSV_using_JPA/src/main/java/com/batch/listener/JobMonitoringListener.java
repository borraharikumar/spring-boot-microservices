package com.batch.listener;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class JobMonitoringListener implements JobExecutionListener {
	
	@Override
	public void beforeJob(JobExecution jobExecution) {
		System.err.println("Job started at " + jobExecution.getStartTime());
		System.err.println("Job execution status :: " + jobExecution.getStatus());
	}
	
	@Override
	public void afterJob(JobExecution jobExecution) {
		System.err.println("Job execution status :: " + jobExecution.getStatus());
		System.err.println("Job ended at " + jobExecution.getEndTime());
	}

}
