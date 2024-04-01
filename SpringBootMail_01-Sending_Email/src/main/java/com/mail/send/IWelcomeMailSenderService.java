package com.mail.send;

import jakarta.mail.MessagingException;

public interface IWelcomeMailSenderService {
	public String sendEmail(String subject, String body, String attachment, String toMails[]) throws MessagingException;
}
