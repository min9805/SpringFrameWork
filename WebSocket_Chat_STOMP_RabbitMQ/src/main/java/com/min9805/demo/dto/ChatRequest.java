package com.min9805.demo.dto;

import lombok.Getter;

@Getter
public class ChatRequest {

    private Long chatRoomId;
    private Long sender;
    private String payload;


}