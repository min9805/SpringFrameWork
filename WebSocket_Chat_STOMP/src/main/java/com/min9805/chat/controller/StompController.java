package com.min9805.chat.controller;

import com.min9805.chat.dto.ChatDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.*;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
@Slf4j
public class StompController {

    @MessageMapping("/chat/{chatRoomId}")
    @SendTo("/sub/chat/{chatRoomId}")
    public String message(
            @DestinationVariable Long chatRoomId,
            @Payload ChatDto request) {
        log.info("chatRoomId: {}, message: {}", chatRoomId, request.getMessage());

        return request.getMessage();
    }
}
