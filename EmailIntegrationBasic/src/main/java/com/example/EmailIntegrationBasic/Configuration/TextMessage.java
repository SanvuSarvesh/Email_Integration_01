package com.example.EmailIntegrationBasic.Configuration;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

// This class is responsible to send text message
public class TextMessage {
    public TextMessage() {
    }
    public void sendNormalTextMessage(String message, String subject,
                                      String to, String from ){
        String host = "smtp.gmail.com";
        Properties properties = System.getProperties();

        // host setting
        properties.put("mail.smtp.host",host);
        properties.put("mail.smtp.port","465");
        properties.put("mail.smtp.ssl.enable","true");
        properties.put("mail.smtp.auth","true");

        // Step :- 1, to get the session object
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("rsanvu001@gmail.com",
                        "miartpfmytkdjexw");
            }
        });
        session.setDebug(true);
        // Step : 2, composing the message
        MimeMessage mimeMessage = new MimeMessage(session);
        try {
            mimeMessage.setFrom(from);
            mimeMessage.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
            mimeMessage.setSubject(subject);
            mimeMessage.setText(message);

            // Step :- 3, send the message using transport class
            Transport.send(mimeMessage);
            System.out.println("Message sent.");
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
    }
}
