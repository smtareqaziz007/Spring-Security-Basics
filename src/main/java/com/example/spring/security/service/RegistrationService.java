package com.example.spring.security.service;

import com.example.spring.security.dto.RegistrationRequest;
import com.example.spring.security.entity.ConfirmationToken;
import com.example.spring.security.entity.User;
import com.example.spring.security.entity.UserRole;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class RegistrationService {

    private final EmailValidator emailValidator;
    private final UserService userService;
    private final ConfirmationTokenService confirmationTokenService;

    public RegistrationService(EmailValidator emailValidator, UserService userService, ConfirmationTokenService confirmationTokenService) {
        this.emailValidator = emailValidator;
        this.userService = userService;
        this.confirmationTokenService = confirmationTokenService;
    }

    public String register(RegistrationRequest registrationRequest) {
        boolean isValidEmail =  emailValidator.test(registrationRequest.getEmail());
        if(!isValidEmail){
            throw new IllegalArgumentException("Invalid email");
        }
        return userService.signUpUser(
                new User(
                        registrationRequest.getName(),
                        registrationRequest.getEmail(),
                        registrationRequest.getPassword(),
                        UserRole.USER
                )
        );
    }

    @Transactional
    public String confirmToken(String token) {
        ConfirmationToken confirmationToken = confirmationTokenService
                .getToken(token)
                .orElseThrow(() ->
                        new IllegalStateException("token not found"));

        if (confirmationToken.getConfirmedAt() != null) {
            throw new IllegalStateException("email already confirmed");
        }

        LocalDateTime expiredAt = confirmationToken.getExpiresAt();

        if (expiredAt.isBefore(LocalDateTime.now())) {
            throw new IllegalStateException("token expired");
        }

        confirmationTokenService.setConfirmedAt(token);
        userService.enableUser(
                confirmationToken.getUser().getEmail());
        return "confirmed";
    }
}
