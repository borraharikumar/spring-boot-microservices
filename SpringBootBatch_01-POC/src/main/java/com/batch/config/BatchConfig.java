package com.batch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import com.batch.listener.JobMonitoringListener;
import com.batch.processor.BookItemProcessor;
import com.batch.reader.BookItemReader;
import com.batch.writer.BookItemWriter;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

	@Autowired
	private PlatformTransactionManager transactionManager;
	@Autowired
	private JobRepository jobRepository;
	@Autowired
	private BookItemReader reader;
	@Autowired
	private BookItemProcessor processor;
	@Autowired
	private BookItemWriter writer;
	@Autowired
	private JobMonitoringListener listener;

	@Bean
	Step step() {
		return new StepBuilder("step", jobRepository)
						.<String, String>chunk(2, transactionManager)
						.reader(reader)
						.processor(processor)
						.writer(writer)
						.build();
	}

	@Bean
	Job job() {
		return new JobBuilder("job", jobRepository)
						.start(step())
						.listener(listener)
						.build();
	}

}
