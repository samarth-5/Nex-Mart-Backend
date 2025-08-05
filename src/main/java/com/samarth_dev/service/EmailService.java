package com.samarth_dev.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSendException;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender javaEmailSender;

    public void sendVerificationOtpEmail(String userEmail, String otp, String subject, String text) throws MessagingException {
        try{
            MimeMessage mimeMessage = javaEmailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,"utf-8");

            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(text);
            mimeMessageHelper.setTo(userEmail);
            javaEmailSender.send(mimeMessage);
        }
        catch (MailException e){
            throw new MailSendException("Failed to send email!!");
        }
    }
}
