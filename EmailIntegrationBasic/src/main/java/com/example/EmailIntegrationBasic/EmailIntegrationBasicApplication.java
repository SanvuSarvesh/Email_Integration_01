package com.example.EmailIntegrationBasic;

import com.example.EmailIntegrationBasic.Configuration.Attachments;
import com.example.EmailIntegrationBasic.Configuration.TextMessage;

public class EmailIntegrationBasicApplication {

	public static void main(String[] args) {
		System.out.println("Initiating...");
		String message = "Hello there, +\n" +
				"I am Sanvu Sarvesh, I am exploring Email Integration using spring boot.+\n" +
				"Thanks and Regards. +\n" +
				"Sanvu Sarvesh +\n" +
				"Software Engineer at Albanero.";
		String subject = "Exploring Email Integration.";
		String from = "rsanvu001@gmail.com";
		String to = "sarveshkr1308@gmail.com";
		TextMessage textMessage = new TextMessage();
		Attachments attachments = new Attachments();
		textMessage.sendNormalTextMessage(message,subject,to,from);
		attachments.sendAttachment(message,subject,to,from);
	}
}
