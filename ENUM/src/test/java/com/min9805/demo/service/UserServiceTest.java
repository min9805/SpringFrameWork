package com.min9805.demo.service;

import com.min9805.demo.status.UserStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void createUser() {
        // Given
        userService.createUser("min9805", "min1925k@gmail.com", UserStatus.ACTIVE);
        userService.createUser("test", "test@test.com", UserStatus.DELETED);

    }
}