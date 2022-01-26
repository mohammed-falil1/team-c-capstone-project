package com.collabera.account_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.stereotype.Service;

@Service

public class EmailSenderService {

	@Autowired
	JavaMailSender javaMailSender;

	public void sendEmail(String from, String to, String subject, String body) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(from);
		message.setTo(to);
		message.setSubject(subject);
		message.setText(body);

		javaMailSender.send(message);

		System.out.println("Mail sent succesfully....");

	}
	
	
//	public void sendEmailAccountOpened(String from, String to, String subject, String body) {
//		SimpleMailMessage message = new SimpleMailMessage();
//		message.setFrom(from);
//		message.setTo(to);
//		message.setSubject(subject);
//		message.setText(body);
//
//		javaMailSender.send(message);
//
//		System.out.println("Mail sent succesfully....");
//
//	}
//	
	
	
	

}
