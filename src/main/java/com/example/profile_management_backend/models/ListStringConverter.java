package com.example.profile_management_backend.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Convert;
import jakarta.persistence.Converter;

import java.util.ArrayList;
import java.util.List;

@Converter
public class ListStringConverter implements AttributeConverter<List<String>, String> {
    private static final ObjectMapper mapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(List<String> attribute) {
        if(attribute == null) return "[]";
        try{
            return mapper.writeValueAsString(attribute);
        }catch (JsonProcessingException e){
            throw new IllegalArgumentException("Error converting list to JSON", e);
        }
    }

    @Override
    public List<String> convertToEntityAttribute(String dbData) {
        if(dbData == null || dbData.isBlank()) return new ArrayList<>();
        try {
            return mapper.readValue(dbData, mapper.getTypeFactory().constructCollectionType(List.class, String.class));
        }catch (JsonProcessingException e){
            throw new IllegalArgumentException("Error converting list to JSON", e);
        }
    }
}
