package com.min9805.demo.domain;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChatHistoryRepository extends MongoRepository<ChatHistory, Long>{
}
