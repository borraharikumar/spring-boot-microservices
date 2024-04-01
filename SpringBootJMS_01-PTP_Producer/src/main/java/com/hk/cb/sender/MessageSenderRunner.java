package com.hk.cb.sender;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MessageSenderRunner {
	
	@Autowired
	private JmsTemplate jmsTemplate;

	@Scheduled(cron = "*/10 * * * * *")
	public void run() throws Exception {
		/*jmsTemplate.send("message_01", new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				 return session.createTextMessage("Sent at :: " + new Date());
			}
		});*/
		
		/*jmsTemplate.send("message_01", ses->{
			return ses.createTextMessage("Sent at :: " + new Date());
		});*/
		
		jmsTemplate.send("message_01", ses->ses.createTextMessage("Sent at :: " + new Date()));
		System.err.println("Message sent");
	}

}
