package com.min9805.demo.status;

import jakarta.persistence.AttributeConverter;

public class AbstractLegacyEnumAttributeConverter<E extends Enum<E> & LegacyCommonType> implements AttributeConverter<E, String> {

    private final Class<E> enumClass;

    public AbstractLegacyEnumAttributeConverter(Class<E> enumClass) {
        this.enumClass = enumClass;
    }

    @Override
    public String convertToDatabaseColumn(E attribute) {
        return attribute.getCode() + "";
    }

    @Override
    public E convertToEntityAttribute(String dbData) {
        int code = Integer.parseInt(dbData);
        return LegacyEnumUtils.of(enumClass, code);
    }
}
