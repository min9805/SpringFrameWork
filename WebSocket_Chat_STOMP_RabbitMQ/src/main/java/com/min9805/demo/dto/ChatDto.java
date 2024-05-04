package com.min9805.demo.dto;

import lombok.Getter;

@Getter
public class ChatDto {

    private Long chatRoomId;
    private String sender;
    private String message;
}

/*
example
{
    "chatRoomId": 1,
    "sender": "min9805",
    "message": "Hello, World!"
}
 */