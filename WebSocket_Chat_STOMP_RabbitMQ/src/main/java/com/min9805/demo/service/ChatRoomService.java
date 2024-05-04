package com.min9805.demo.service;

import com.min9805.demo.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatRoomService {
    private final ChatRoomRepository chatRoomRepository;
    private final UserChatRepository userChatRepository;

    public ChatRoom createChatRoom(List<Long> userId, String name) {
        ChatRoom chatRoom= ChatRoom.builder().name(name).build();
        chatRoomRepository.save(chatRoom);
        userId.forEach(id -> userChatRepository.save(UserChat.builder()
                .chatRoom(chatRoom)
                .user(User.builder().id(id).build())
                .build()));

        return chatRoom;
    }

    public List<ChatRoom> findAll(Long userId) {
        return userChatRepository.findByUserId(userId).stream().map(UserChat::getChatRoom).toList();
    }

    public ChatRoom joinChat(List<Long> userId) {
        List<ChatRoom> byUserChatsUserIdIn = chatRoomRepository.findChatRoomsByUserIds(userId, 2L);
        if (!byUserChatsUserIdIn.isEmpty()) {
            return byUserChatsUserIdIn.get(0);
        } else {
            String roomName = userId.stream().map(String::valueOf).reduce((a, b) -> a + "," + b).orElse("default");
            return createChatRoom(userId, roomName);
        }
    }

}
