package com.example.fipetable.service;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;
import java.util.Map;

public interface IDataParser {
    <T> T parseData(String data, Class<T> tClass);
    <T> List<T> parseListData(String data, Class<T> tClass);
}
