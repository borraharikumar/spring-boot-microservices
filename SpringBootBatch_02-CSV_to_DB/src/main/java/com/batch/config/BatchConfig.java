package com.batch.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import com.batch.listener.JobMonitoringListener;
import com.batch.model.ExamResult;
import com.batch.processor.ExamResultItemProcessor;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
	
	@Autowired
	private JobRepository jobRepository;
	@Autowired
	private PlatformTransactionManager transactionManager;
	@Autowired
	private JobMonitoringListener listener;
	@Autowired
	private ExamResultItemProcessor itemProcessor;
	@Autowired
	private DataSource dataSource;
	
	@Bean
	FlatFileItemReader<ExamResult> itemReader(){
		FlatFileItemReader<ExamResult> itemReader = new FlatFileItemReader<ExamResult>();
		itemReader.setResource(new ClassPathResource("ExamResults.csv"));
		
		DefaultLineMapper<ExamResult> lineMapper = new DefaultLineMapper<ExamResult>();
		
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setDelimiter(",");
		lineTokenizer.setNames("id", "name", "college_code", "percentage");
		
		BeanWrapperFieldSetMapper<ExamResult> fieldSetMapper = new BeanWrapperFieldSetMapper<ExamResult>();
		fieldSetMapper.setTargetType(ExamResult.class);
		
		lineMapper.setFieldSetMapper(fieldSetMapper);
		lineMapper.setLineTokenizer(lineTokenizer);
		
		itemReader.setLineMapper(lineMapper);
		itemReader.setLinesToSkip(1);
		
		return itemReader;
	}
	
	@Bean
	JdbcBatchItemWriter<ExamResult> itemWriter(){
		JdbcBatchItemWriter<ExamResult> itemWriter = new JdbcBatchItemWriter<ExamResult>();
		itemWriter.setDataSource(dataSource);
		itemWriter.setSql("INSERT INTO ExamResult VALUES(:id, :name, :college_code, :percentage)");
		itemWriter.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<ExamResult>());
		return itemWriter;
	}
	
	@Bean
	Step step() {
		return new StepBuilder("step1", jobRepository)
						.<ExamResult, ExamResult>chunk(10, transactionManager)
						.reader(itemReader())
						.processor(itemProcessor)
						.writer(itemWriter())
						.build();
	}
	
	@Bean
	Job job() {
		return new JobBuilder("job1", jobRepository)
						.listener(listener)
				 		.incrementer(new RunIdIncrementer())
				 		.start(step())
				 		.build();
	}

}
