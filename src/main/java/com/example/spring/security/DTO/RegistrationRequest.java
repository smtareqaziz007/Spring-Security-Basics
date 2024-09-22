package com.example.spring.security.DTO;

import lombok.*;

@Getter
@EqualsAndHashCode
@ToString
public class RegistrationRequest {
    private String name;
    private String email;
    private String password;

    public RegistrationRequest(){}

    public RegistrationRequest(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
