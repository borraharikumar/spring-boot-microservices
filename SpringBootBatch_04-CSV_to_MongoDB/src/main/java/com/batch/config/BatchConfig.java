package com.batch.config;

import java.util.Random;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.data.MongoItemWriter;
import org.springframework.batch.item.data.builder.MongoItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.transaction.PlatformTransactionManager;

import com.batch.listener.JobMonitoringListener;
import com.batch.model.ExamResult;
import com.batch.processor.ExamResultItemProcessor;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
	
	@Autowired
	private JobMonitoringListener listener;
	@Autowired
	private PlatformTransactionManager transactionManager;
	@Autowired
	private ExamResultItemProcessor processor;
	@Autowired
	private MongoTemplate template;
	@Autowired
	private JobRepository jobRepository;
	
	@Bean
	FlatFileItemReader<ExamResult> itemReader() {
		return new FlatFileItemReaderBuilder<ExamResult>()
								.name("reader")
								.resource(new ClassPathResource("distinction_students.csv"))
								.delimited().delimiter(",")
								.names("id", "name", "college_code", "percentage")
								.targetType(ExamResult.class)
								.build();
	}
	
	@Bean
	MongoItemWriter<ExamResult> itemWriter() {
		return new MongoItemWriterBuilder<ExamResult>()
								.collection("distinction_students")
								.template(template)
								.build();
	}
	
	@Bean
	Step step() {
		return new StepBuilder(new Random().toString(), jobRepository)
								.<ExamResult, ExamResult>chunk(100, transactionManager)
								.reader(itemReader())
								.processor(processor)
								.writer(itemWriter())
								.build();
	}
	
	@Bean
	Job job() {
		return new JobBuilder(new Random().toString(), jobRepository)
								.listener(listener)
								.incrementer(new RunIdIncrementer())
								.start(step())
								.build();
	}

}
