package com.batch.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.batch.model.ExamResult;

@Component
public class ExamResultIemProcessor implements ItemProcessor<ExamResult, ExamResult> {

	@Override
	public ExamResult process(ExamResult item) throws Exception {
		if(item.getPercentage()>70)
			return item;
		return
			null;
	}

}
