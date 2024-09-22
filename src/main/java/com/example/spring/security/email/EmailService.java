package com.example.spring.security.email;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
//@AllArgsConstructor
public class EmailService implements EmailSender {

    private final static Logger logger = LoggerFactory.getLogger(EmailService.class);
    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }


    @Override
    @Async
    public void send(String to, String subject, String body) {

        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, "utf-8");
            helper.setText(body, true);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setFrom("smtareq-2018825356@cs.du.ac.bd");
            mailSender.send(message);
        }
        catch (Exception e) {
            logger.error("failed to send email ", e);
            throw new IllegalArgumentException("failed to send email");
        }
    }
}
