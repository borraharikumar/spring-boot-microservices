package com.hk.kafka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hk.kafka.producer.MessageProducer;
import com.hk.kafka.store.MessageStore;

@RestController
@RequestMapping("/kafka")
public class KafkaMessageController {
	
	@Autowired
	private MessageStore messageStore;
	
	@Autowired
	private MessageProducer messageProducer;
	
	@PostMapping("/send")
	public ResponseEntity<String> sendMessage(@RequestParam("message") String message) {
		return new ResponseEntity<String>(messageProducer.sendMessage(message), HttpStatus.OK);
	}
	
	@GetMapping("/readAll")
	public ResponseEntity<List<String>> receiveMessages() {
		return new ResponseEntity<List<String>>(messageStore.getMessages(), HttpStatus.OK);
	}

}
