package com.batch.listener;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class JobMonitoringListener implements JobExecutionListener {
	
	@Override
	public void beforeJob(JobExecution jobExecution) {
		System.err.println("Job status       :: " + jobExecution.getStatus());
		System.err.println("Job start time   :: " + jobExecution.getStartTime());
	}
	
	@Override
	public void afterJob(JobExecution jobExecution) {
		System.err.println("Job end time     :: " + jobExecution.getEndTime());
		System.err.println("Job status       :: " + jobExecution.getStatus());
	}

}
