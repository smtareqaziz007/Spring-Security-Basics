package Service;

import Entity.User;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    public User register(User user) {
        return user;
    }
}
