package com.batch.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.transaction.PlatformTransactionManager;

import com.batch.listener.JobMonitoringListener;
import com.batch.model.ExamResult;
import com.batch.processor.ExamResultIemProcessor;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
	
	@Autowired
	private PlatformTransactionManager transactionManager;
	@Autowired
	private JobMonitoringListener jobListener;
	@Autowired
	private ExamResultIemProcessor processor;
	@Autowired
	private DataSource dataSource;
	@Autowired
	private JobRepository jobRepository;
	
	@Bean
	JdbcCursorItemReader<ExamResult> itemRader() {
		return new JdbcCursorItemReaderBuilder<ExamResult>()
							.name("reader")
							.dataSource(dataSource)
							.sql("SELECT id, name, college_code, percentage FROM ExamResult")
							.beanRowMapper(ExamResult.class)
							.build();
	}
	
	@Bean
	FlatFileItemWriter<ExamResult> itemWriter(){
		return new FlatFileItemWriterBuilder<ExamResult>()
							.name("writer")
							.resource(new FileSystemResource("D:\\Documents\\csvs\\distinction_students.csv"))
							.delimited().delimiter(",")
							.names("id", "name", "college_code", "percentage")
							.build();
	}
	
	@Bean
	Step step() {
		return new StepBuilder("step1", jobRepository)
							.<ExamResult, ExamResult>chunk(100, transactionManager)
							.reader(itemRader())
							.writer(itemWriter())
							.processor(processor)
							.build();
	}
	
	@Bean
	Job job() {
		return new JobBuilder("job1", jobRepository)
							.start(step())
							.listener(jobListener)
							.incrementer(new RunIdIncrementer())
							.build();
	}

}
