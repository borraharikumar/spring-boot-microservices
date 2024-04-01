package com.hk.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer {
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	private static final String TOPIC_NAME = "topic-03";
	
	public String sendMessage(String message) {
		kafkaTemplate.send(TOPIC_NAME, message);
		return "Message sent";
	}

}
