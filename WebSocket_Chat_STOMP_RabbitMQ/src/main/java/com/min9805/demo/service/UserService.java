package com.min9805.demo.service;

import com.min9805.demo.domain.User;
import com.min9805.demo.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User createUser(String name) {
        return userRepository.save(User.builder().name(name).build());
    }

    public List<User> findAll(Long userId) {
        return userRepository.findByIdNot(userId);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
