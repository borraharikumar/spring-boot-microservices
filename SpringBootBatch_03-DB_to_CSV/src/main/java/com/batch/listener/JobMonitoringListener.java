package com.batch.listener;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class JobMonitoringListener implements JobExecutionListener {
	
	@Override
	public void beforeJob(JobExecution jobExecution) {
		System.err.println("Job execution status   :: " + jobExecution.getStatus());
		System.err.println("Is job starting        :: " + jobExecution.isRunning());
		System.err.println("Job start time         :: " + jobExecution.getStartTime());
	}
	
	@Override
	public void afterJob(JobExecution jobExecution) {
		System.err.println("Is job ending          :: " + jobExecution.isStopping());
		System.err.println("Job end time           :: " + jobExecution.getEndTime());
		System.err.println("Job execution status   :: " + jobExecution.getStatus());
	}
	
	

}
