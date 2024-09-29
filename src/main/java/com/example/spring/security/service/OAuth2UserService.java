package com.example.spring.security.service;

import com.example.spring.security.entity.User;
import com.example.spring.security.entity.UserRole;
import com.example.spring.security.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class OAuth2UserService extends DefaultOAuth2UserService {
    private final UserRepository userRepository;
    public OAuth2UserService(UserRepository userRepository) {this.userRepository = userRepository;}

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) {
        OAuth2User oAuth2User = super.loadUser(userRequest);

        String email = oAuth2User.getAttribute("email");
        String name = oAuth2User.getAttribute("name");

        log.info("email: {}, name: {}", email, name);

        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isEmpty()) {
            User newUser = new User();
            newUser.setEmail(email);
            newUser.setName(name);
            newUser.setEnabled(true);
            newUser.setIsOAuthUser(true);
            newUser.setUserRole(UserRole.USER);
            userRepository.save(newUser);
        }

        return oAuth2User;
    }
}
