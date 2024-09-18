package Controller;

import Entity.User;
import Service.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "auth")
@AllArgsConstructor
public class AuthController {

    private final RegistrationService registrationService;

    public User register(@RequestBody User user) {
        return registrationService.register(user);
    }
}
