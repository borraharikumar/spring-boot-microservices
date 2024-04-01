package com.example.demo.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

@Service
public class WishMessageServiceImpl implements IWishMessageService {

	@Override
	public String generateWishMessage() {
		Integer hour = LocalDateTime.now().getHour();
		if(hour<12) 		return "Good morning user";
		else if(hour<16) 	return "Good afternoon user";
		else if(hour<20) 	return "Good evening user";
		else 				return "Good night user";
	}

}
