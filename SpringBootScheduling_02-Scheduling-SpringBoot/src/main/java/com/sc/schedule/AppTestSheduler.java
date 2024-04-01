package com.sc.schedule;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class AppTestSheduler {
	
	@Scheduled(initialDelay = 5000, fixedDelay = 4000)
	public void test() {
		System.err.println("Scheduled :: " + new Date());
	}

}
