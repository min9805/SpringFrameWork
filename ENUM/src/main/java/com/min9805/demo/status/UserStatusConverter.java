package com.min9805.demo.status;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

//@Converter
//public class UserStatusConverter implements AttributeConverter<UserStatus, Integer> {
//    @Override
//    public Integer convertToDatabaseColumn(UserStatus attribute) {
//        return attribute.getCode();
//    }
//
//    @Override
//    public UserStatus convertToEntityAttribute(Integer dbData) {
//        return UserStatus.of(dbData);
//    }
//}

public class UserStatusConverter extends AbstractLegacyEnumAttributeConverter<UserStatus> {
    public UserStatusConverter() {
        super(UserStatus.class);
    }
}