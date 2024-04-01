package com.hk.cb.sender;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MessagePublisher {
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	private int i=1;
	
	@Scheduled(cron = "*/5 * * * * *")
	public void sendMessage() {
		jmsTemplate.send("message", ses->ses.createTextMessage(new Date().toString()));
		System.err.println("Message sent :: " + i);
		i++;
	}

}
