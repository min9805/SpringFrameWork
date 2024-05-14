package com.min9805.demo.service;

import com.min9805.demo.domain.ChatHistory;
import com.min9805.demo.domain.ChatHistoryRepository;
import com.min9805.demo.domain.UserRepository;
import com.min9805.demo.dto.ChatDto;
import com.min9805.demo.dto.ChatRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChatHistroyService {
    private final ChatHistoryRepository chatHistoryRepository;
    private final UserRepository userRepository;

    public void saveChat(ChatRequest chatRequest) {
        ChatHistory chatHistory = ChatHistory.builder()
                .chatRoomId(chatRequest.getChatRoomId())
                .senderId(chatRequest.getSender())
                .payload(chatRequest.getPayload())
                .messageType("MESSAGE")
                .build();

        chatHistoryRepository.save(chatHistory);
    }

    public List<ChatDto> getChatHistory(Long chatRoomId) {
        List<ChatHistory> chatHistory = chatHistoryRepository.findByChatRoomId(chatRoomId);
        return chatHistory.stream().map(
                chat -> {
                    String senderName = userRepository.findById(chat.getSenderId()).get().getName();
                    return ChatDto.builder()
                            .senderName(senderName)
                            .payload(chat.getPayload())
                            .messageType(chat.getMessageType())
                            .createdAt(chat.getCreatedAt())
                            .build();
                }
        ).collect(Collectors.toList());
    }
}
