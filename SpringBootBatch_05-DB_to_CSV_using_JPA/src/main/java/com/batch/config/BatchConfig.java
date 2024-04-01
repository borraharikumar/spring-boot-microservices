package com.batch.config;

import java.util.Random;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.database.builder.JpaItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import com.batch.listener.JobMonitoringListener;
import com.batch.model.ExamResult;
import com.batch.processor.ExamResultItemProcessor;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
	
	@Autowired
	private ExamResultItemProcessor itemProcessor;
	@Autowired
	private PlatformTransactionManager platformTransactionManager;
	@Autowired
	private EntityManagerFactory entityManagerFactory;
	@Autowired
	private JobMonitoringListener jobMonitoringListener;
	@Autowired
	private JobRepository jobRepository;
	
	@Bean
	FlatFileItemReader<ExamResult> itemReader() {
		return new FlatFileItemReaderBuilder<ExamResult>()
							.name("reader")
							.resource(new ClassPathResource("ExamResults.csv"))
							.delimited().delimiter(",").names("id", "name", "college_code", "percentage")
							.targetType(ExamResult.class)
							.linesToSkip(1)
							.build();
	}
	
	@Bean
	JpaItemWriter<ExamResult> itemWriter() {
		return new JpaItemWriterBuilder<ExamResult>()
							.entityManagerFactory(entityManagerFactory)
							.build();
	}
	
	@Bean
	Step step() {
		return new StepBuilder(new Random().toString(), jobRepository)
							.<ExamResult, ExamResult>chunk(100, platformTransactionManager)
							.reader(itemReader())
							.processor(itemProcessor)
							.writer(itemWriter())
							.build();
	}
	
	@Bean
	Job job() {
		return new JobBuilder(new Random().toString(), jobRepository)
							.incrementer(new RunIdIncrementer())
							.listener(jobMonitoringListener)
							.start(step())
							.build();
	}

}
