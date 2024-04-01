package com.mail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.mail.send.WelcomeMailSenderServiceImpl;

import jakarta.mail.MessagingException;

@SpringBootApplication
public class SpringBootMail01SendingEmailApplication {

	public static void main(String[] args) throws MessagingException {
		ApplicationContext context = SpringApplication.run(SpringBootMail01SendingEmailApplication.class, args);
		
		WelcomeMailSenderServiceImpl serviceImpl = context.getBean(WelcomeMailSenderServiceImpl.class);
		
		String msg = serviceImpl.sendEmail("Open the email to know about it...!",
							  "Welcome to Spring boot mail...!",
							  "D:\\HTML, CSS & JavaScript\\HTML\\Images\\welcome.jfif",
							  new String[] {"harikumarborra0406@gmail.com",
									  		"harikumarborra3@gmail.com",
									  		"mahadev.b2409@gmail.com"});
		System.err.println(msg);
	}

}
