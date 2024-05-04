package com.min9805.demo.service;

import com.min9805.demo.domain.User;
import com.min9805.demo.domain.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Test
    void createUser() {
        User min9805 = userService.createUser("min9805");
        User test1 = userService.createUser("test1");
        User test2 = userService.createUser("test2");

        assertThat(min9805.getName()).isEqualTo("min9805");
        assertThat(test1.getName()).isEqualTo("test1");
        assertThat(test2.getName()).isEqualTo("test2");
    }

}