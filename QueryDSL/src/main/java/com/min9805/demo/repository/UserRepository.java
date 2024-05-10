package com.min9805.demo.repository;


import com.min9805.demo.doamin.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
