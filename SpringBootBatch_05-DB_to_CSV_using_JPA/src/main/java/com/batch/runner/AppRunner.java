package com.batch.runner;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner {
	
	@Autowired
	private JobLauncher jobLauncher;
	@Autowired
	private Job job;

	@Override
	public void run(String... args) throws Exception {
		JobParameters jobParameters = new JobParametersBuilder().toJobParameters();
		JobExecution jobExecution = jobLauncher.run(job, jobParameters);
		System.err.println(jobExecution.getExitStatus());
	}

}
