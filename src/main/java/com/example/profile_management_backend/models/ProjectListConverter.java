package com.example.profile_management_backend.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.ArrayList;
import java.util.List;

@Converter
public class ProjectListConverter implements AttributeConverter<List<Project>, String> {

    private static final ObjectMapper mapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(List<Project> attribute) {
        if (attribute == null) return "[]";
        try {
            return mapper.writeValueAsString(attribute);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Error converting Project list to JSON", e);
        }
    }

    @Override
    public List<Project> convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.isBlank()) return new ArrayList<>();
        try {
            return mapper.readValue(dbData, mapper.getTypeFactory().constructCollectionType(List.class, Project.class));
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Error converting JSON to List<Project>", e);
        }
    }
}
