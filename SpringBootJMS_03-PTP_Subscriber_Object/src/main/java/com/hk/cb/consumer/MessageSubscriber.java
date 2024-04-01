package com.hk.cb.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.hk.cb.model.Student;

@Component
public class MessageSubscriber {
	
	@JmsListener(destination = "message_02")
	public void getMessage(Student student) {
		System.err.println(student);
	}

}
