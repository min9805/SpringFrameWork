package com.min9805.demo.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;

public interface UserChatRepository extends JpaRepository<UserChat, Long> {
    List<UserChat> findByUserId(Long userId);
}
