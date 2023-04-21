package com.example.EmailIntegrationBasic.Configuration;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.time.chrono.MinguoChronology;
import java.util.Properties;

// This class is responsible for sending attachments
public class Attachments {
    public Attachments() {
    }
    public void sendAttachment(String message, String subject,
                               String to , String from){
        String host = "smtp.gmail.com";
        Properties properties = System.getProperties();

        // host setting
        properties.put("mail.smtp.host",host);
        properties.put("mail.smtp.port","465");
        properties.put("mail.smtp.ssl.enable","true");
        properties.put("mail.smtp.auth","true");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("rsanvu001@gmail.com",
                        "miartpfmytkdjexw");
            }
        });
        session.setDebug(true);
        MimeMessage mimeMessage = new MimeMessage(session);
        try{
            mimeMessage.setFrom(from);
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            mimeMessage.setSubject(subject);

            String path = "/home/albanero/Downloads/image.png";
            MimeMultipart mimeMultipart = new MimeMultipart();
            MimeBodyPart mimeBodyPartText = new MimeBodyPart();
            MimeBodyPart mimeBodyPartFile = new MimeBodyPart();

            try {
                mimeBodyPartText.setText(message);
                File file = new File(path);
                mimeBodyPartFile.attachFile(file);
                mimeMultipart.addBodyPart(mimeBodyPartText);
                mimeMultipart.addBodyPart(mimeBodyPartFile);
            }catch (Exception exception){
                exception.printStackTrace();
            }
            mimeMessage.setContent(mimeMultipart);
            Transport.send(mimeMessage);
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
        System.out.println("Mail Sent.");
    }
}
