package com.mail.send;

import java.io.File;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.activation.DataSource;
import jakarta.activation.FileDataSource;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class WelcomeMailSenderServiceImpl implements IWelcomeMailSenderService {
	
	@Autowired
	private JavaMailSender sender;
	
	@Value("${spring.mail.username}")
	private String fromEmail;

	@Override
	public String sendEmail(String subject, String body, String attachment, String[] toMails) throws MessagingException {
		MimeMessage mimeMessage = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		helper.setFrom(fromEmail);
		helper.setCc(toMails);
		helper.setSubject(subject);
		helper.setSentDate(new Date());
		helper.setText(body);
		DataSource stream = new FileDataSource(new File(attachment));
		helper.addAttachment("welcome.jfif", stream);
		sender.send(mimeMessage);
		return "Email sent successfully...!";
	}

}
