package com.min9805.demo.status;

import lombok.Getter;

@Getter
public enum UserStatus implements LegacyCommonType{
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

    public static UserStatus of(int code) {
        for (UserStatus value : values()) {
            if (value.code == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid UserStatus code: " + code);
    }
}
