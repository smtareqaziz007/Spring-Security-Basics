package com.example.spring.security.email;

public interface EmailSender {
    void send(String to, String subject, String body);
}
