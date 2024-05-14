package com.min9805.demo.controller;

import com.min9805.demo.dto.ChatDto;
import com.min9805.demo.service.ChatHistroyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api")
public class StompController {
    private final ChatHistroyService chatHistroyService;

    @MessageMapping("/chat/{chatRoomId}")
    @SendTo("/topic/chat/{chatRoomId}")
    public ChatDto message(
            @DestinationVariable Long chatRoomId,
            @Payload ChatDto request) {
        log.info("chatRoomId: {}, message: {}", chatRoomId, request.getPayload());

        chatHistroyService.saveChat(request);

        return request;
    }
}
