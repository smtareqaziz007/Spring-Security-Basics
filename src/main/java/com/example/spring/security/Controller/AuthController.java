package com.example.spring.security.Controller;

import com.example.spring.security.DTO.RegistrationRequest;
import com.example.spring.security.Service.RegistrationService;
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
    public String register(@RequestBody RegistrationRequest request) {
//        logger.info("------------------------------------Ashchi-----------------------------------------");
        return registrationService.register(request);
    }

    @GetMapping
    public String home() {
        return "home";
    }

}
