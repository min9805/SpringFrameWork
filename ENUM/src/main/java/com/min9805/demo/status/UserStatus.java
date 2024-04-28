package com.min9805.demo.status;

public enum UserStatus {
    ACTIVE(0, "활성화"),
    INACTIVE(1, "비활성화"),
    DELETED(2, "삭제"),
    BLOCKED(3, "차단"),
    PENDING(4, "대기");

    private final int code;
    private final String description;

    UserStatus(int code, String description) {
        this.code = code;
        this.description = description;
    }
}
