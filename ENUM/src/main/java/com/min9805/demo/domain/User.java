package com.min9805.demo.domain;

import com.min9805.demo.status.UserStatus;
import com.min9805.demo.status.UserStatusConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

//    @Enumerated(EnumType.STRING)
//    private UserStatus status;

    @Convert(converter = UserStatusConverter.class)
    private UserStatus status;
}
