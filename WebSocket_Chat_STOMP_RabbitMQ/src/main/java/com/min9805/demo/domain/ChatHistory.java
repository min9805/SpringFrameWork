package com.min9805.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "chatHistory")
@Builder
public class ChatHistory {
    @Id
    private String id;
    private Long chatRoomId;
    private String senderId;
    private String messageType;
    private String payload;

    @CreatedDate
    private LocalDateTime createdAt;
}
