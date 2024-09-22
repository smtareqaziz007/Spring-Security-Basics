package com.example.spring.security.Service;

import com.example.spring.security.DTO.RegistrationRequest;
import com.example.spring.security.Entity.User;
import com.example.spring.security.Entity.UserRole;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    private final EmailValidator emailValidator;
    private final UserService userService;

    public RegistrationService(EmailValidator emailValidator, UserService userService) {
        this.emailValidator = emailValidator;
        this.userService = userService;
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
}
