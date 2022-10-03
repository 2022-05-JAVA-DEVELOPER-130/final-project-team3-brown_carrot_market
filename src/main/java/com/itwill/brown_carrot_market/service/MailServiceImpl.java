package com.itwill.brown_carrot_market.service;

import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import com.itwill.brown_carrot_market.dao.UserInfoDao;
import com.itwill.brown_carrot_market.dto.Invitation;

@Service
public class MailServiceImpl implements MailService {
	
	@Autowired
	@Qualifier("userDaoImpl")
	private UserInfoDao userDao;

	@Override
	public boolean mailsender(Invitation invitation) throws Exception {

		String invi_code = RandomString();
		
		boolean b = false;
		JavaMailSenderImpl sender = new JavaMailSenderImpl();
		String id = "browncarrotmarket@gmail.com";
		String passwd = "ltxxmvgyzxwwfgpc";

		sender.setHost("smtp.gmail.com");
		sender.setPort(587);
		sender.setUsername(id);
		sender.setPassword(passwd);
		sender.setDefaultEncoding("UTF-8");
		Properties javaMailProperties = new Properties();
		javaMailProperties.put("mail.smtp.auth", true);
		javaMailProperties.put("mail.smtp.starttls.enable", true);

		/*
		 * javaMailProperties.put("mail.smtp.ssl.enable", true);
		 * javaMailProperties.put("mail.smtp.ssl.trust","smtp.gmail.com" );
		 */
		sender.setJavaMailProperties(javaMailProperties);

		MimeMessagePreparator preparator = new MimeMessagePreparator() {

			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(invitation.getInvi_email())); // 수신 메일
				mimeMessage.setSubject("흙당근 마켓에" + invitation.getUser_id() + "님이 초대합니다.", "UTF-8");
				mimeMessage.setText("흙당근 마켓에" + invitation.getUser_id() + "님이 초대합니다.\n초대코드: "+invi_code+"\n http://localhost/brown_carrot_market/main",
						"UTF-8");
			}
		};
		try {
			sender.send(preparator);
			invitation.setInvi_email(invi_code);
			userDao.createInvitation(invitation);
			b = true;
		} catch (MailException mex) {
			System.out.println(mex.getMessage());
		}
		return b;
	}
	//create-randomString
	public static String RandomString() {
		
		int leftLimit = 48; //numeral '0'
		int rightLimit = 122; //letter 'z'
		int targetStringLength = 10;
		
		Random random = new Random();
		String generateString =
			random.ints(leftLimit, rightLimit+1)
			.filter(i ->(i<=57||i>=65)&&(i<=90||i>97))
			.limit(targetStringLength)
			.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
			.toString()
			;
		return generateString;
	}

}
