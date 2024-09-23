package com.example.spring.security.dto;

import lombok.*;

@Getter
@Setter
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
