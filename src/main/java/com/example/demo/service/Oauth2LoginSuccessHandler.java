package com.example.demo.service;

import com.example.demo.dao.entity.User;
import com.example.demo.dao.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class Oauth2LoginSuccessHandler {
    private final UserRepository userRepository;

    @Transactional
    public User processOAuthPostLogin(OAuth2User oAuth2User) {
        String email = oAuth2User.getAttribute("email");
        Optional<User> userOptional = userRepository.getUserByEmail(email);
        User user;
        if (Objects.isNull(userOptional)) {
            // Register new user
            user = new User();
            user.setEmail(email);
            user.setName(oAuth2User.getAttribute("name"));
            // Additional attributes can be set here if needed
            userRepository.save(user);

        } else {
            // User already exists, update information if necessary
            user = userOptional.get();
            // This is where you could update the user's profile information if it has changed
        }
        return user;
    }
}
