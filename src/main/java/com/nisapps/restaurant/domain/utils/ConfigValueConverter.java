package com.nisapps.restaurant.domain.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = false)
public class ConfigValueConverter implements AttributeConverter<ConfigValue, String> {
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(ConfigValue attribute) {
        try {
            return mapper.writeValueAsString(attribute);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ConfigValue convertToEntityAttribute(String data) {
        try {
            return mapper.readValue(data, ConfigValue.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
