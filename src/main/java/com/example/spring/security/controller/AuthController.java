package com.example.spring.security.controller;

import com.example.spring.security.dto.RegistrationRequest;
import com.example.spring.security.service.RegistrationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/register")
public class AuthController {

    private final RegistrationService registrationService;

    Logger logger = LoggerFactory.getLogger(AuthController.class);

    public AuthController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }


    @PostMapping
    public String register(@ModelAttribute RegistrationRequest request) {
//        logger.info("------------------------------------Ashchi-----------------------------------------");
        logger.info("Registering user {}", request);
        String token = registrationService.register(request);

        return "redirect:/";
    }

    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }

    @GetMapping
    public String register() {
        return "register";
    }

}
