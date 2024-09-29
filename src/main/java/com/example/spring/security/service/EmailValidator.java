package com.example.spring.security.service;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;

@Service
public class EmailValidator implements Predicate<String> {
    @Override
    public boolean test(String email) {

//        TODO: Regex to validate email
        return email.contains("@");
    }
}

// Email validation can be done in other ways, I should use that instead of this