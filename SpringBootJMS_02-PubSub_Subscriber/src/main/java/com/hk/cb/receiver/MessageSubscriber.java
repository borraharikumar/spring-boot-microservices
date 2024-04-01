package com.hk.cb.receiver;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageSubscriber {
	
	@JmsListener(destination = "message")
	public void getMessage(String message) {
		System.err.println(message);
	}

}
