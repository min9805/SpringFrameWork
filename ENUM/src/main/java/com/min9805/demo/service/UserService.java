package com.min9805.demo.service;

import com.min9805.demo.domain.User;
import com.min9805.demo.domain.UserRepository;
import com.min9805.demo.status.UserStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;


    public void createUser(String name, String email, UserStatus status) {
        userRepository.save(User.builder()
                .name(name)
                .email(email)
                .status(status)
                .build());
    }
}
