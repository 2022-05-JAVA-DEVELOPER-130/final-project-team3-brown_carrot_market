package com.itwill.brown_carrot_market.service;

import org.springframework.mail.javamail.JavaMailSender;

import com.itwill.brown_carrot_market.dto.Invitation;

public interface MailService {
	
	boolean mailsender(Invitation invitation) throws Exception;

}
