package com.min9805.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "chatHistory")
@Builder
@Getter
public class ChatHistory {
    @Id
    private String id;
    private Long chatRoomId;
    private Long senderId;
    private String messageType;
    private String payload;

    @CreatedDate
    private LocalDateTime createdAt;
}
