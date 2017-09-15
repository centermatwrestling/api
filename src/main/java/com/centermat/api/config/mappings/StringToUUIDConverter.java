package com.centermat.api.config.mappings;

import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

import java.util.UUID;

public class StringToUUIDConverter implements Converter<String, UUID> {
    public UUID convert(String source) {
        return UUID.fromString(source);
    }
}