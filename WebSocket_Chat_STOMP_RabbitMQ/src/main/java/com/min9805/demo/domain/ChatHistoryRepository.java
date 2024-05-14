package com.min9805.demo.domain;

import com.min9805.demo.dto.ChatDto;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ChatHistoryRepository extends MongoRepository<ChatHistory, Long>{
    List<ChatHistory> findByChatRoomId(Long chatRoomId);
}
