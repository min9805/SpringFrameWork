package com.min9805.demo.domain;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Override
    <S extends User> List<S> findAll(Example<S> example);

    List<User> findByIdNot(Long id);
}
