package com.example.fipetable.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ModelsDTO(@JsonAlias("modelos") List<DataDTO> dataDTOList) { }