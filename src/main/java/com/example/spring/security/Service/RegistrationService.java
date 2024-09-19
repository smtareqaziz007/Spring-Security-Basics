package com.example.spring.security.Service;

import com.example.spring.security.DTO.RegistrationRequest;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    public String register(RegistrationRequest registrationRequest) {
        return "Working";
    }
}
