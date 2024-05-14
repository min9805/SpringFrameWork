package com.min9805.demo.controller;

import com.min9805.demo.dto.ChatDto;
import com.min9805.demo.dto.ChatRequest;
import com.min9805.demo.service.ChatHistroyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api")
public class StompController {
    private final ChatHistroyService chatHistroyService;

    @MessageMapping("/chat/{chatRoomId}")
    @SendTo("/topic/chat/{chatRoomId}")
    public ChatRequest message(
            @DestinationVariable Long chatRoomId,
            @Payload ChatRequest request) {
        log.info("chatRoomId: {}, message: {}", chatRoomId, request.getPayload());

        chatHistroyService.saveChat(request);

        return request;
    }

    @GetMapping("/history/{chatRoom}")
    public List<ChatDto> getChatHistory(@PathVariable Long chatRoom) {
        return chatHistroyService.getChatHistory(chatRoom);
    }
}
