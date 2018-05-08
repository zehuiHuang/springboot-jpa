package com.example.base.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Email {
	public static void  Emaimain(String args) throws Exception {
		System.out.println("Sending mail...");
		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.host", "smtp.sina.com");
		props.setProperty("mail.user", "zhaoji223@sina.com");
		props.setProperty("mail.password", "zhaoji941022");
		props.setProperty("mail.smtp.auth", "true");
		Session mailSession = Session.getDefaultInstance(props, null);
		mailSession.setDebug(true);
		Transport transport = mailSession.getTransport();
		MimeMessage message = new MimeMessage(mailSession);

		message.setSubject("HTML  mail with images");
		message.setFrom(new InternetAddress("zhaoji223@sina.com"));
		List<String> toEmail = new ArrayList<String>();
		toEmail.add("942496121@qq.com");
		InternetAddress[] a = new InternetAddress[toEmail.size()];
		for (int i = 0; i < toEmail.size(); i++) {
			a[i] = new InternetAddress(toEmail.get(i));

		}
//		for (int j = 0; j < a.length; j++) {
//			System.out.println(a[j] + "-============================");
//		}
		
		
		
		message.addRecipients(Message.RecipientType.TO, a);
		MimeMultipart multipart = new MimeMultipart("related");

		// first part (the html)
		BodyPart messageBodyPart = new MimeBodyPart();
		 messageBodyPart.setContent(args, "text/html;charset=UTF-8");
		 System.out.println(args);
		// add it
		multipart.addBodyPart(messageBodyPart);
		// second part (the image)
		messageBodyPart = new MimeBodyPart();
		DataSource fds = new FileDataSource("/users/yangyibo/photo/gril.jpg");
		messageBodyPart.setDataHandler(new DataHandler(fds));
		messageBodyPart.setHeader("Content-ID", "<image>");
		// add it
		multipart.addBodyPart(messageBodyPart);
		message.setContent(multipart);

		transport.connect(null, "zhaoji223@sina.com", "zhaoji941022");
		transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
		transport.close();
	}
}


