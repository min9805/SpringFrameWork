package com.min9805.demo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.min9805.demo.domain.ChatHistory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChatDto {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String senderName;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String payload;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String messageType;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime createdAt;

}
