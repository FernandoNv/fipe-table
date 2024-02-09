package com.example.fipetable.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.util.List;
import java.util.Map;

public class DataParser implements IDataParser {
    ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public <T> T parseData(String data, Class<T> tClass) {
        try {
            return objectMapper.readValue(data, tClass);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public <T> List<T> parseListData(String data, Class<T> tClass) {
        CollectionType list = objectMapper.getTypeFactory()
                .constructCollectionType(List.class, tClass);

        try {
            return objectMapper.readValue(data, list);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
