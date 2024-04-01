package com.hk.kafka.store;

import java.util.ArrayList;
import java.util.List;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Component
@Getter
public class MessageStore {
	
	private List<String> messages = new ArrayList<String>();
	
	@KafkaListener(topics = "topic-03", groupId = "topic-03_group")
	public void readAllMessages(String message) {
		messages.add(message);
	}
	
}
