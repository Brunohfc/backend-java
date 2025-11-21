package com.brunohfc.restapi205.demo.mail;

import com.brunohfc.restapi205.demo.config.EmailConfig;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.StringTokenizer;

@Component
public class EmailSender implements Serializable {

    Logger logger = LoggerFactory.getLogger(EmailSender.class);
    private final JavaMailSender mailSender;
    private String to;
    private String subject;
    private String body;
    private ArrayList<InternetAddress> recipients = new ArrayList<>();
    private File attachment;

    public EmailSender(JavaMailSender mailSender){
        this.mailSender = mailSender;
    }

    public EmailSender to(String to) throws AddressException {
        this.to = to;
        this.recipients = getRecipients(to);
        return  this;
    }

    private ArrayList<InternetAddress> getRecipients(String to) throws AddressException {
        String withoutSpace = to.replaceAll("\\s","");

        StringTokenizer token = new StringTokenizer(withoutSpace,";");

        ArrayList<InternetAddress> recipientsList = new ArrayList<>();
            while (token.hasMoreElements()){
                try {
                    recipientsList.add(new InternetAddress(token.nextElement().toString()));
                }catch (AddressException e){
                    throw new RuntimeException(e);
                }
            }

        return  recipientsList;
    }


    public EmailSender withSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public EmailSender withMessage(String body) {
        this.body = body;
        return this;
    }

    public EmailSender withAttachment(String fileDir) {
        this.attachment = new File(fileDir);;
        return this;
    }

    public void sendEmail(EmailConfig config){
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(config.getUsername());
            helper.setSubject(subject);
            helper.setTo(recipients.toArray(new InternetAddress[0]));
            helper.setText(body, true);
            if(attachment != null){
                helper.addAttachment(attachment.getName(), attachment);
            }
            mailSender.send(message);
            logger.info("Enviando email para %s com o assunto %n", to, subject);
        }catch (MessagingException e ){
            throw new RuntimeException("Error ao mandar email");
        }finally {
            reset();
        }
    }

    public void reset(){
        this.to = null;
        this.subject = null;
        this.body = null;
        this.recipients = null;
        this.attachment = null;
    }
}
