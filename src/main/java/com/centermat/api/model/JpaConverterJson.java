package com.centermat.api.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.AttributeConverter;
import java.util.HashMap;

@Slf4j
public class JpaConverterJson implements AttributeConverter<Object, String> {

    private final static ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(Object meta) {
        try {
            java.util.Map<String,Object> wrapper = new HashMap<>();
            wrapper.put("class",meta.getClass().getCanonicalName());
            wrapper.put("value",objectMapper.writeValueAsString(meta));
            return objectMapper.writeValueAsString(wrapper);
        } catch (JsonProcessingException ex) {
            log.error("Unexpected IOEx decoding json from database: ",ex);
            return null;
            // or throw an error
        }
    }

    @Override
    public Object convertToEntityAttribute(String dbData) {
        try {
            final java.util.Map map = objectMapper.readValue(dbData, java.util.Map.class);
            final String value = map.get("value").toString();
            final Class clazz = Class.forName(map.get("class").toString());
            return objectMapper.readValue(value, clazz);
        } catch (Exception ex) {
            log.error("Unexpected IOEx decoding json from database: " + dbData,ex);
        }
        return null;
    }
}