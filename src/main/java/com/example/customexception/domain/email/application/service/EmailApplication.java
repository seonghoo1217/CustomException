package com.example.customexception.domain.email.application.service;

import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

@Service
public interface EmailApplication {
    MimeMessage createVerifiedEmail(String toEmail,String nickname);
}
