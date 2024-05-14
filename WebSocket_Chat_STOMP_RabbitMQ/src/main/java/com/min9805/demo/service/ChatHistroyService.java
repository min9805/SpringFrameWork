package com.min9805.demo.service;

import com.min9805.demo.domain.ChatHistory;
import com.min9805.demo.domain.ChatHistoryRepository;
import com.min9805.demo.dto.ChatDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatHistroyService {
    private final ChatHistoryRepository chatHistoryRepository;

    public void saveChat(ChatDto chatDto) {
        ChatHistory chatHistory = ChatHistory.builder()
                .chatRoomId(chatDto.getChatRoomId())
                .senderId(chatDto.getSender())
                .payload(chatDto.getPayload())
                .messageType("MESSAGE")
                .build();

        chatHistoryRepository.save(chatHistory);
    }
}
