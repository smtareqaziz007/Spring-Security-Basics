package com.example.spring.security.controller;

import com.example.spring.security.dto.RegistrationRequest;
import com.example.spring.security.service.RegistrationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/register")
public class AuthController {

    private final RegistrationService registrationService;

    Logger logger = LoggerFactory.getLogger(AuthController.class);

    public AuthController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }


    @PostMapping
    public String register(@RequestBody RegistrationRequest request) {
//        logger.info("------------------------------------Ashchi-----------------------------------------");
        return registrationService.register(request);
    }

    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }

    @GetMapping
    public String home() {
        return "home";
    }

}
