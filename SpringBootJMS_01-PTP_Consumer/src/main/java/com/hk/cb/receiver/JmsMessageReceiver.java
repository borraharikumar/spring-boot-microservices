package com.hk.cb.receiver;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class JmsMessageReceiver {
	
	@JmsListener(destination = "message_01")
	public void receiveMessage(String message) {
		System.err.println(message);
	}

}
