package com.hk.cb.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.hk.cb.model.Student;

@Component
public class MessagePublisher {
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Scheduled(cron = "*/5 * * * * *")
	public void sendMessage() {
		jmsTemplate.convertAndSend("message_02", new Student("17X21A0302", "Harikumar", "ME"));
		System.err.println("Message sent");
	}

}
