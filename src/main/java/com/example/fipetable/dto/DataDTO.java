package com.example.fipetable.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataDTO(
        @JsonAlias("codigo")
        String code,
        @JsonAlias("nome")
        String name
) { }
